package House.Items;

import House.DisplayElement;
import House.Observer;
import House.Subject;
import com.example.logic.HelloController;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

    public class Fan implements Observer, DisplayElement {

        private String location;
        private boolean isOn;
        private List<Observer> observers;
        private int hour;
        private int day;
        private Subject OutHome;
        private HelloController helloController;

        public Fan(Subject OutHome, HelloController helloController){
            this.OutHome = OutHome;
            OutHome.registerObserver (this);
            this.helloController = helloController;
        }

        public void update(int hour,int day) {
            this.hour= hour;
            this.day=day;
            if (hour==6){
                System.out.println("El ventilador se prendio a la "+hour);
                helloController.fanNotifStatus(true);
            }
            if (hour==21){
                System.out.println("El ventilador se apagó a la "+hour);
                helloController.fanNotifStatus(false);
            }
            display();
        }






        public Fan(String location) {
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
            String text = (location + " fan is " + (isOn ? "on" : "off"));
            return text;
        }
    }
