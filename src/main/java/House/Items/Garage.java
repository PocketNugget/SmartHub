package House.Items;
import House.DisplayElement;
import House.Observer;
import House.Subject;
import com.example.logic.HelloController;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Garage implements Observer, DisplayElement {
    private String location;
    private boolean isOn;
    private int dia;
    private List<Observer> observers;
    private int hour;
    private int day;
    private Subject OutHome;
    private HelloController helloController;
    private Button garageNotif;

    public Garage(Subject OutHome, HelloController helloController){
        this.OutHome = OutHome;
        this.helloController = helloController;
        OutHome.registerObserver (this);
    }

    public void update(int hour,int day) {
        this.hour= hour;
        this.day=day;
        if (hour==18){
            System.out.println("El garage se cerró a las "+hour);
            helloController.garageNotifStatus(false);
        }

        display();
    }









    public Garage(String location) {
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
        String text = (location + " garage is " + (isOn ? "open" : "closed"));
        return text;
    }
}
