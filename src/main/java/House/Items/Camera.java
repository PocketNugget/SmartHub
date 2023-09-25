package House.Items;

import House.DisplayElement;
import House.Observer;
import House.Subject;
import com.example.logic.HelloController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


import java.util.ArrayList;
import java.util.List;


public class Camera implements Observer, DisplayElement {
    private String location;
    private boolean isOn;
    private int hour;
    private int day;

    private Subject OutHome;

    private List<Observer> observers;

    // Declare instance variables to store the values
    private int storedHora;
    private int storedDia;
    @FXML

    private HelloController helloController;

    private Button cameraNotif;
    public Camera(Subject OutHome,HelloController helloController){
        this.helloController = helloController;
        this.OutHome = OutHome;
        OutHome.registerObserver(this);
    }
    public void update(int hour,int day) {
        this.hour= hour;
        this.day=day;
        if (hour==9){
        System.out.println("la camara se prendio a la "+hour);
            helloController.cameraNotifStatus(true);
        }
        display();
    }


    public Camera(String location) {
        this.location = location;
        this.isOn = false;
        this.observers = new ArrayList<>();
    }

    public void on() {
        this.isOn = true;
        // Update the hora value when turning on
        hour = 1; // Change this to the desired hour value

    }

    public void off() {
        this.isOn = false;
        // Update the hora value when turning off
        hour = 0; // Change this to the desired hour value

    }





    @Override
    public String display() {
                String text =("The "+location+"camera is"+(isOn ? "watching" : " not watching"));
        return text;
    }


}
