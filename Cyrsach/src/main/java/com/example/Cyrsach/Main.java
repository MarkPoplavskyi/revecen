package com.example.Cyrsach;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {



    @Override
    public void start(Stage stage) throws IOException {// завантаження головного вікна
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainWin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 515);
        stage.setTitle("Електричні прилади");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
            launch();
    }
}