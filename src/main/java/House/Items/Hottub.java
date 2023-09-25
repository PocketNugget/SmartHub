package House.Items;



import House.DisplayElement;
import House.Observer;
import House.Subject;
import com.example.logic.HelloController;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Hottub implements Observer, DisplayElement {
    private String location;
    private boolean isOn;
    private int hora;
    private int dia;
    private List<Observer> observers;
    private int hour;
    private int day;
    private Subject OutHome;
    private Button hottubNotif;
    private HelloController helloController;

    public Hottub(Subject OutHome, HelloController helloController){
        this.OutHome = OutHome;
        this.helloController = helloController;
        OutHome.registerObserver (this);
    }

    public void update(int hour,int day) {
        this.hour= hour;
        this.day=day;
        if (hour==18){
            System.out.println("la bañera se prendio a las "+hour);
            helloController.hottubNotifStatus(true);
        }
        if (hour==22){
            System.out.println("la bañera se apagó a las "+hour);
            helloController.hottubNotifStatus(false);
        }
        display();
    }





    public Hottub(String location) {
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
        String text=(location + " hottub is " + (isOn ? "bubbling" : "not bubbling :("));
        return text;
    }
}