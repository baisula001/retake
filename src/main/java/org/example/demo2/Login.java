package org.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * @Auther: willson2008
 * @Date: 19/02/2024 - 02 - 19 - 20:18
 * @Description: org.example.demo2
 * @Version: 1.0
 */
public class Login {
    @FXML
    private Button Butten;

    @FXML
    private PasswordField PassWord;

    @FXML
    private TextField UserName;

    @FXML
    private Label WrongLogin;

    @FXML
    void UserLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {

        Application m = new Application();
        if (UserName.getText().equals("java") && PassWord.getText().equals("123")){
            WrongLogin.setText("SUCCESS!");

            Application.changeScene("Chessboard.fxml");

        }

        else if (UserName.getText().isEmpty() && PassWord.getText().isEmpty()) {
            WrongLogin.setText("please enter your date.");
        }

        else {
            WrongLogin.setText("Wrong username or password!");
        }
    }

}
