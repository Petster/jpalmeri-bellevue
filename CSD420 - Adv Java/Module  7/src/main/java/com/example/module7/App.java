package com.example.module7;

/*
    Jason Palmeri
    5/31/22
    Assignment 7
    create a GUI program with 4 circles using fxml and style them with CSS classes and id's
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 240);
        scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());
        stage.setTitle("Jason Palmeri - Module 7");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}