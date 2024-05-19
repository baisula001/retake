package org.example.demo2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {

    private static Stage stg;

    @Override
    public void start(Stage primarystage) throws IOException {
        stg = primarystage;
        primarystage.setResizable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        primarystage.setTitle("Login Page!");
        primarystage.setScene(scene);
        primarystage.show();
    }

    public static Stage getPrimaryStage() {
        return stg;
    }

    public static void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }

}