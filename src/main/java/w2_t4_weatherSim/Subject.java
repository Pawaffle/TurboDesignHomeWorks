package w2_t4_weatherSim;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        System.out.println("Adding observer " + observer);
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        System.out.println("Removing observer " + observer);
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}