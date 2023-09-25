package com.example.logic;
import House.Items.Camera;
import House.Subject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;

public class HelloApplication extends Application {
    @Override
    //Comando para lanzar applicación
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {




        launch();



    }


}//onHelloButtonClick, welcomeText