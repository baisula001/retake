package org.example.demo2.org.example.demo2;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import org.example.demo2.State;

import java.util.*;

/**
 * @Auther: willson2008
 * @Date: 15/03/2024 - 03 - 15 - 19:06
 * @Description: org.example.demo2.org.example.demo2
 * @Version: 1.0
 */
public class BoardGameModule implements State<Position>{

    public static final int BOARD_SIZE = 5;

    private ReadOnlyObjectWrapper<Square>[][] board = new ReadOnlyObjectWrapper[BOARD_SIZE][4];

    public BoardGameModule(){
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < 4; j++) {
                board[i][j] = new ReadOnlyObjectWrapper<>(
                        switch (i){
                            case 0 -> (j % 2 != 0) ? Square.BLACK : Square.NONE;
                            case BOARD_SIZE -1 ->(j % 2 != 0) ? Square.WHITE : Square.NONE;
                            default -> Square.NONE;
                        }
                );
            }
        }
    }
    public ReadOnlyObjectProperty<Square> squareProperty(int i , int j){
        return board[i][j].getReadOnlyProperty();
    }
    public Square getSquare(Position p){
        return board[p.row()][p.col()].get();
    }
    private void setSquare(Position p, Square square){
        board[p.row()][p.col()].set(square);
    }
    public void move(Position from,Position to){
        setSquare(to, getSquare(from));
        setSquare(from,Square.NONE);
    }

    public boolean canMove(Position from, Position to) {
        return isOnBoard(from) && isOnBoard(to) && !isEmpty(from) && isEmpty(to) && isDiagonalMove(from, to);
    }
    public boolean isEmpty(Position p){
        return getSquare(p)==Square.NONE;
    }
    public static boolean isOnBoard(Position p){
        return 0<=p.row() && p.col() < BOARD_SIZE && 0<=p.col() && p.col() < 4;
    }
    public static boolean isDiagonalMove(Position from, Position to) {
        var dx = Math.abs(to.row() - from.row());
        var dy = Math.abs(to.col() - from.col());
        return dx == dy && dx != 0;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(board[i][j].get().ordinal()).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BoardGameModule module = new BoardGameModule();
        System.out.println(module);
    }

    @Override
    public boolean isSolved() {
        if (board[0][1].get() != Square.WHITE || board[0][3].get() != Square.WHITE) {
            return false;
        }

        // 检查最后一行的白色棋子是否都位于第一行的黑色棋子的位置
        if (board[BOARD_SIZE - 1][1].get() != Square.BLACK || board[BOARD_SIZE - 1][3].get() != Square.BLACK) {
            return false;
        }
        return true;
    }






    @Override
    public boolean isLegalMove(Position move) {
        return false;
    }

    @Override
    public void makeMove(Position move) {

    }

    @Override
    public Set<Position> getLegalMoves() {
        return null;
    }

    @Override
    public State<Position> clone() {
        return null;                    //我的Position类是record类，所以默认自带 clone方法，所以不需要实现clone方法；
    }

    public void reset() {
        // 重置棋盘上的所有棋子状态
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < 4; j++) {
                switch (i) {
                    case 0, BOARD_SIZE - 1 -> board[i][j].set((j % 2 != 0) ? Square.BLACK : Square.NONE);
                    default -> board[i][j].set(Square.NONE);
                }
            }
        }
    }
}
