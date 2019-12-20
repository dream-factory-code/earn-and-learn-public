package hr.dreamfactory.lectures.homework1.model;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    List<Observer> observers = new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public void doStuff(){
        observers.forEach(t -> t.update());
    }

}
