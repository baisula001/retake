package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.example.demo2.org.example.demo2.BoardGameModule;
import org.example.demo2.util.BoardGameMoveSelector;

import java.io.IOException;

/**
 * @Auther: willson2008
 * @Date: 19/02/2024 - 02 - 19 - 20:53
 * @Description: org.example.demo2
 * @Version: 1.0
 */
public class AfterLogin {

    @FXML
    private GridPane board;

    @FXML
    private Button reset;

    @FXML
    private AnchorPane exit;

    @FXML
    private Button logout;

    private BoardGameModule boardGameModule; // 声明 BoardGameModule 变量

    public AfterLogin() {
        boardGameModule = new BoardGameModule(); // 在构造函数中初始化 BoardGameModule
    }

    public void UserLogout(ActionEvent event) throws IOException {
        Application M = new Application();
        Application.changeScene("sample.fxml");
    }

    @FXML
    private void handleResetButtonMouseClicked(MouseEvent event) {
        // 重置按钮被鼠标点击时的逻辑
        System.out.println("Reset button mouse clicked!");
        resetGame();
    }

    private void resetGame() {
        // 清除选择的方块
        clearSelectionStyle();
        // 重置游戏状态
        if (boardGameModule != null) {
            boardGameModule.reset(); // 调用 BoardGameModule 的 reset 方法
        } else {
            System.err.println("BoardGameModule is not initialized!");
        }
    }

    private void clearSelectionStyle() {
        for (Node child : board.getChildren()) {
            if (child instanceof StackPane) {
                StackPane square = (StackPane) child;
                square.getStyleClass().remove("selected");
            }
        }
    }

    @FXML
    public void handleResetButtonClick(ActionEvent actionEvent) {
        // 重置按钮被点击时的逻辑
        System.out.println("Reset button clicked!");
        this.resetGame();
    }
}