package com.example.logic;

import House.Items.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.Stack;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class HelloController {

    private boolean undoAction = false;
    private Stack<String> actionStack = new Stack<>();
    boolean light=true,fan=true, cam=true,gar=true,tub=true,ster=true,t=true;
    @FXML
    private Label welcomeText, Question, Time;
    private Button lastButtonPressed;
    private boolean lastButtonState;
    private final Light livingRoomLight;
    private final Fan ceilingFan;
    private final Camera frontcamera;
    private final Garage garage;
    private final Hottub hottub;
    private final Stereo stereo;
    private final Tv tv;
    @FXML
    private Button cameraNotif, fanNotif, garageNotif, hottubNotif, lightNotif, stereoNotif, tvNotif,lightButton, fanButton,cameraButton,garageButton,hottubButton,stereoButton,tvButton, listoButton;
    @FXML
    private TextField dayInp;
    private Timeline timeline;

    private boolean noseya = false;




    public void initialize() {
        updateTimeLabel(); // Update the time label initially

        // Create a timeline to update the time label every second
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateTimeLabel())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTimeLabel() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formattedTime = currentTime.format(formatter);
        Time.setText(formattedTime);
    }
    public HelloController() {

        // Initialize the Light instance and set up the observer in the constructor
        livingRoomLight = new Light("Living Room");
        ceilingFan = new Fan("Living Room");
        frontcamera = new Camera("Front");
        garage = new Garage("Front");
        hottub = new Hottub("Garden");
        stereo = new Stereo("Living Room");
        tv = new Tv("Living Room");




    };



    @FXML
    public void onLightButton(ActionEvent actionEvent) {
        if (light) {
            livingRoomLight.on();
            light = false;
            welcomeText.setText(livingRoomLight.display());
            lightButton.setStyle("-fx-background-color: #7289da;");
            notifStatus(lightNotif, true);
        } else if (!light) {
            livingRoomLight.off();
            light = true;
            welcomeText.setText(livingRoomLight.display());
            lightButton.setStyle("-fx-background-color: #424549;");
            try {
                Thread.sleep(1000); // Simulate time passing (1 second per hour)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifStatus(lightNotif, false);
        }

        // Actualiza el último botón presionado y su estado
        lastButtonPressed = lightButton;
        lastButtonState = !light;

        // Agregar la acción al stack
        if (!undoAction) {
            String actionDescription = light ? "Light on" : "Light off";
            actionStack.push(actionDescription);
        }
    }


    public void onCameraButton(ActionEvent actionEvent) {

        if (cam) {
            frontcamera.on();
            cam = false;
            welcomeText.setText(frontcamera.display());
            cameraButton.setStyle("-fx-background-color: #7289da;");
            notifStatus(cameraNotif, true);
            System.out.println("ASJADFNAJDSNMVF");
        } else if (!cam) {
            frontcamera.off();
            cam = true;
            welcomeText.setText(frontcamera.display());
            cameraButton.setStyle("-fx-background-color: #424549;");
            notifStatus(cameraNotif, false);
        }

        // Actualiza el último botón presionado y su estado
        lastButtonPressed = cameraButton;
        lastButtonState = !cam;

        // Agregar la acción al stack
        if (!undoAction) {
            String actionDescription = cam ? "Camera on" : "Camera off";
            actionStack.push(actionDescription);
        }
    }



    public void onFanButton(ActionEvent actionEvent) {
        if (fan) {
            ceilingFan.on();
            fan = false;
            welcomeText.setText(ceilingFan.display());
            fanButton.setStyle("-fx-background-color: #7289da;");
            notifStatus(fanNotif, true);

        } else if (!fan) {
            ceilingFan.off();
            fan = true;
            welcomeText.setText(ceilingFan.display());
            fanButton.setStyle("-fx-background-color: #424549;");
            notifStatus(fanNotif, false);
        }

        // Actualiza el último botón presionado y su estado
        lastButtonPressed = fanButton;
        lastButtonState = !fan;

        // Agregar la acción al stack
        if (!undoAction) {
            String actionDescription = fan ? "Fan on" : "Fan off";
            actionStack.push(actionDescription);
        }
    }

    public void onGarageButton(ActionEvent actionEvent) {
        if (gar) {
            garage.on();
            gar = false;
            welcomeText.setText(garage.display());
            garageButton.setStyle("-fx-background-color: #7289da;");
            notifStatus(garageNotif, true);

        } else if (!gar) {
            garage.off();
            gar = true;
            welcomeText.setText(garage.display());
            garageButton.setStyle("-fx-background-color: #424549;");
            notifStatus(garageNotif, false);
        }

        // Actualiza el último botón presionado y su estado
        lastButtonPressed = garageButton;
        lastButtonState = !gar;

        // Agregar la acción al stack
        if (!undoAction) {
            String actionDescription = gar ? "Gar on" : "Gar off";
            actionStack.push(actionDescription);
        }
    }

    public void onHottubButton(ActionEvent actionEvent) {
        if (tub) {
            hottub.on();
            tub = false;
            welcomeText.setText(hottub.display());
            hottubButton.setStyle("-fx-background-color: #7289da;");
            notifStatus(hottubNotif, true);
        } else if (!tub) {
            hottub.off();
            tub = true;
            welcomeText.setText(hottub.display());
            hottubButton.setStyle("-fx-background-color: #424549;");
            notifStatus(hottubNotif, false);
        }

        // Actualiza el último botón presionado y su estado
        lastButtonPressed = hottubButton;
        lastButtonState = !tub;

        // Agregar la acción al stack
        if (!undoAction) {
            String actionDescription = tub ? "Tub on" : "Tub off";
            actionStack.push(actionDescription);
        }
    }

    public void onStereoButton(ActionEvent actionEvent) {
        if (ster) {
            stereo.on();
            ster = false;
            welcomeText.setText(stereo.display());
            stereoButton.setStyle("-fx-background-color: #7289da;");
            notifStatus(stereoNotif, true);

        } else if (!ster) {
            stereo.off();
            ster = true;
            welcomeText.setText(stereo.display());
            stereoButton.setStyle("-fx-background-color: #424549;");
            notifStatus(stereoNotif, false);
        }

        // Actualiza el último botón presionado y su estado
        lastButtonPressed = stereoButton;
        lastButtonState = !ster;

        // Agregar la acción al stack
        if (!undoAction) {
            String actionDescription = ster ? "Ster on" : "Ster off";
            actionStack.push(actionDescription);
        }
    }

    public void onTvButton(ActionEvent actionEvent) {
        if (t) {
            tv.on();
            t = false;
            welcomeText.setText(tv.display());
            tvButton.setStyle("-fx-background-color: #7289da;");
            notifStatus(tvNotif, true);
        } else if (!t) {
            tv.off();
            t = true;
            welcomeText.setText(tv.display());
            tvButton.setStyle("-fx-background-color: #424549;");
            notifStatus(tvNotif, false);
        }

        // Actualiza el último botón presionado y su estado
        lastButtonPressed = tvButton;
        lastButtonState = !t;

        // Agregar la acción al stack
        if (!undoAction) {
            String actionDescription = t ? "TV on" : "TV off";
            actionStack.push(actionDescription);
        }
    }



    public void onVacationButton(ActionEvent actionEvent) {
        dayInp.setVisible(true);
        listoButton.setVisible(true);
        Question.setVisible(true);

    }
int hour=0;
    int day=0;
    public void onListoButton(ActionEvent actionEvent) {
        // Crear una tarea para ejecutar byeBye en segundo plano
        Task<Void> byeByeTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                OutHome outHome = new OutHome(dayInp, HelloController.this);
                cameraNotifStatus(true);
                outHome.byeBye(hour,day);
                return null;
            }
        };

        // Manejar el evento de finalización de la tarea
        byeByeTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // Tarea completada, puedes realizar acciones después de byeBye aquí
            }
        });

        // Iniciar la tarea en segundo plano
        Thread thread = new Thread(byeByeTask);
        thread.setDaemon(true); // Opcional: Establecer como demonio para que se cierre cuando la aplicación se cierre
        thread.start();
    }



    public void dayInput(ActionEvent actionEvent) {

    }

    public void onUndoButton(ActionEvent actionEvent) {
        undoAction = true;
        if (!actionStack.isEmpty()) {
            String lastAction = actionStack.pop();
            // Dependiendo de la acción registrada, revierte el estado adecuado
            if (lastAction.equals("Light on")) {
                onLightButton(null);
            } else if (lastAction.equals("Light off")) {
                onLightButton(null);
            } else if (lastAction.equals("Camera on")) {
                onCameraButton(null);
            } else if (lastAction.equals("Camera off")) {
                onCameraButton(null);
            } else if (lastAction.equals("Fan on")) {
                onFanButton(null);
            } else if (lastAction.equals("Fan off")) {
                onFanButton(null);
            } else if (lastAction.equals("Gar on")) {
                onGarageButton(null);
            } else if (lastAction.equals("Gar off")) {
                onGarageButton(null);
            } else if (lastAction.equals("Tub on")) {
                onHottubButton(null);
            } else if (lastAction.equals("Tub off")) {
                onHottubButton(null);
            } else if (lastAction.equals("Ster on")) {
                onStereoButton(null);
            } else if (lastAction.equals("Ster off")) {
                onStereoButton(null);
            } else if (lastAction.equals("TV on")) {
                onTvButton(null);
            } else if (lastAction.equals("TV off")) {
                onTvButton(null);
            }


            // Actualiza el estado del último botón y su estado
            lastButtonState = !lastButtonState;
        }
        undoAction = false;
    }
    public void notifStatus(Control targetElement, boolean status) {
        if (status){
            targetElement.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            targetElement.setStyle("-fx-background-color: #424549;");
        }
        System.out.println("HOLA");
    }
    public void cameraNotifStatus(boolean status){
        if (status){
            cameraNotif.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            cameraNotif.setStyle("-fx-background-color: #424549;");
        }
    }
    public void fanNotifStatus(boolean status){
        if (status){
            fanNotif.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            fanNotif.setStyle("-fx-background-color: #424549;");
        }
    }
    public void garageNotifStatus(boolean status){
        if (status){
            garageNotif.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            garageNotif.setStyle("-fx-background-color: #424549;");
        }
    }
    public void hottubNotifStatus(boolean status){
        if (status){
            hottubNotif.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            hottubNotif.setStyle("-fx-background-color: #424549;");
        }
    }
    public void lightNotifStatus(boolean status){
        if (status){
            lightNotif.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            lightNotif.setStyle("-fx-background-color: #424549;");
        }
    }
    public void stereoNotifStatus(boolean status){
        if (status){
            stereoNotif.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            stereoNotif.setStyle("-fx-background-color: #424549;");
        }
    }
    public void tvNotifStatus(boolean status){
        if (status){
            tvNotif.setStyle("-fx-background-color: orange;");
        } else if (!status) {
            tvNotif.setStyle("-fx-background-color: #424549;");
        }
    }
}

