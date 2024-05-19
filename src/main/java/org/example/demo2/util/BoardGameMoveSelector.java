package org.example.demo2.util;


import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import org.example.demo2.AfterLogin;
import org.example.demo2.org.example.demo2.BoardGameModule;
import org.example.demo2.org.example.demo2.Position;
import org.example.demo2.org.example.demo2.Square;

public class BoardGameMoveSelector {

    public enum Phase{
        SELECT_FROM,
        SELECT_TO,
        READY_TO_MOVE
    }

    public Phase getPhase() {
        return phase.get();
    }

    private AfterLogin afterLogin;


    public BoardGameMoveSelector(AfterLogin afterLogin, BoardGameModule module) {
        this.afterLogin = afterLogin;
        // 其他初始化...
    }

    private static BoardGameMoveSelector instance;

    public static BoardGameMoveSelector getInstance(AfterLogin afterLogin, BoardGameModule module){
        if (instance == null) {
            instance = new BoardGameMoveSelector(afterLogin, module);
        }
        return instance;
    }

    private BoardGameModule module;
    private ReadOnlyObjectWrapper<Phase> phase = new ReadOnlyObjectWrapper<>(Phase.SELECT_FROM);
    private boolean invalidSelection = false;
    private Position from;
    private Position to;

    public BoardGameMoveSelector(BoardGameModule module){
        this.module = module;
    }
    public ReadOnlyObjectProperty<Phase> phaseProperty(){
        return phase.getReadOnlyProperty();
    }
    public boolean isReadyToMove(){
        return phase.get() == Phase.READY_TO_MOVE;
    }
    public void select(Position position){
        switch(phase.get()){
            case SELECT_FROM -> selectFrom(position);
            case SELECT_TO -> selectTo(position);
            case READY_TO_MOVE -> throw new IllegalStateException();
        }
    }
    private void selectFrom(Position position){
        if (!module.isEmpty(position)){
            from = position;
            phase.set(Phase.SELECT_TO);
            invalidSelection = false;
        }else {
            invalidSelection = true;
        }
    }
    private void selectTo(Position position){
        if (module.canMove(from, position)){
            to = position;
            phase.set(Phase.READY_TO_MOVE);
            invalidSelection = false;
        }else {
            invalidSelection = true;
        }
    }
    public Position getFrom(){
        if (phase.get()==Phase.SELECT_FROM){
            throw new IllegalStateException();
        }
        return from;
    }
    public Position getTo(){
        if (phase.get()!=Phase.READY_TO_MOVE){
            throw new IllegalStateException();
        }
        return to;
    }
    public boolean isInvalidSelection(){
        return invalidSelection;
    }
    public void makeMove(){
        if (phase.get()!=Phase.READY_TO_MOVE){
            throw new IllegalStateException();
        }
        module.move(from,to);
        reset();
    }
    public void reset(){
        from = null;
        to = null;
        phase.set(Phase.SELECT_FROM);
        invalidSelection = false;
    }


}
