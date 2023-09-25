package House.Items;

import House.DisplayElement;
import House.Observer;
import House.Subject;
import com.example.logic.HelloController;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Stereo implements Observer, DisplayElement {
    private String location;
    private boolean isOn;
    private int hora;
    private int dia;
    private List<Observer> observers;
    private int hour;
    private int day;
    private Subject OutHome;
    private HelloController helloController; // Agrega una referencia al controlador
    private Button stereoNotif;

    public Stereo(Subject OutHome, HelloController helloController){
        this.OutHome = OutHome;
        this.helloController = helloController;
        OutHome.registerObserver (this);
    }

    public void update(int hour,int day) {
        this.hour= hour;
        this.day=day;
        if (hour==10){
            System.out.println("el radio se prendio a las "+hour);
            helloController.stereoNotifStatus(true);
        }
        if (hour==19){
            System.out.println("el radio se apagó a las "+hour);
            helloController.stereoNotifStatus(false);
        }

        display();
    }




    public Stereo(String location) {
        this.location = location;
        this.isOn = false;
        this.observers = new ArrayList<>();
    }

    public void on() {
        this.isOn = true;

    }

    public void off() {
        this.isOn = false;

    }



    @Override
    public String display() {
        String text=(location + " stereo is " + (isOn ? "on" : "off"));
        return text;
    }
}