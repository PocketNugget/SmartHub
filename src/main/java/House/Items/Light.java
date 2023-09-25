package House.Items;

import House.DisplayElement;
import House.Observer;
import House.Subject;
import com.example.logic.HelloController;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Light implements Observer, DisplayElement {
    private String location;
    private boolean isOn;
    private int hora;
    private int dia;
    private List<Observer> observers;
    private int hour;
    private int day;
    private Subject OutHome;
    private HelloController helloController; // Agrega una referencia al controlador
    private Button lightNotif;

    public Light(Subject OutHome, HelloController helloController) {
        this.helloController = helloController;
        this.OutHome = OutHome;
        OutHome.registerObserver(this);
    }

    // ...

    public void update(int hour, int day) {
        this.hour = hour;
        this.day = day;
        if (hour == 18) {
            System.out.println("La luz se prendió a las " + hour);
            helloController.lightNotifStatus(true);
        }
        if (hour == 8) {
            System.out.println("La luz se apagó a las " + hour);
            helloController.lightNotifStatus(false);
        }

        display();
    }




    public Light(String location) {
        this.location = location;
        this.isOn = false;
        this.observers = new ArrayList<>();
    }

    public void on() {
        this.isOn = true;
        notifyObservers();
    }

    public void off() {
        this.isOn = false;
        notifyObservers();
    }






    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(hora,dia);
        }
    }

    @Override
    public String display() {
        String text=(location + " light is " + (isOn ? "on" : "off"));
        return text;
    }
}