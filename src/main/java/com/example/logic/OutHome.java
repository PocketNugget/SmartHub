
package com.example.logic;

import House.Items.*;
import House.Observer;
import House.Subject;
import javafx.scene.control.TextField;
import java.time.LocalTime;
import java.util.ArrayList;
import com.example.logic.HelloController;

public class OutHome implements Subject {

    private ArrayList<Observer> observers = new ArrayList<>();
    private TextField dayInp;
    private int day;
    private int hour;

    Camera addObserverCamera;
    Fan addObserverFan;
    Garage addObserverGarage;
    Hottub addObserverHottub;
    Light addObserverLight;
    Stereo addObserverStereo;
    Tv addObserverTv;

    public OutHome(TextField dayInp, HelloController helloController) {

        this.dayInp = dayInp;
        LocalTime currentTime = LocalTime.now();
        this.hour = currentTime.getHour();
        String labelText = dayInp.getText();
        this.day = Integer.parseInt(labelText);
        addObserverCamera = new Camera(this, helloController);
        addObserverFan = new Fan(this, helloController);
        addObserverGarage = new Garage(this, helloController);
        addObserverHottub = new Hottub(this, helloController);
        addObserverLight = new Light(this, helloController);
        addObserverLight = new Light(this, helloController); // Passing helloController
        addObserverStereo = new Stereo(this, helloController);
        addObserverTv = new Tv(this, helloController);
        byeBye(hour, day);

    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }


    public void remover(Observer o) {
        int i = observers.indexOf(o);
        if (i >=0){
            observers.remove (i);
        }
    }


    public void notifyObservers() {
        for (int i=0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(hour, day);
        }
    }
    public void timeChanged (){
        notifyObservers();
    }



    public void byeBye(int hour, int day) {
        for(int i = 0; i<day; day--){
            System.out.println("Days left til coming back : "+day);
            this.day = day;
            //aqui tienes que extraer el valor de hora y meterlo a otra función de objeto(Light, camera, garage etc....)
            for (int j = 24 ; j>hour; hour++){
                this.hour = hour;
                System.out.println("the hour is: "+hour);
                timeChanged();
                    //aqui tienes que extraer el valor de hora y meterlo a otra función de objeto(Light, camera, garage etc....)
                try {
                    Thread.sleep(1000); // Simulate time passing (1 second per hour)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            hour = 0;

   timeChanged();
        }
        System.out.println("welcome back!");
    }



    public void update(int hora, int dia) {
        hour = hora;
        day = dia;

    }


}
