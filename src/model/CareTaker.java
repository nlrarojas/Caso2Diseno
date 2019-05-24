package Model;

import java.util.ArrayList;

public class CareTaker<T> {

    ArrayList<Memento<T>> mementos;

    public void addMemento(Memento<T> newMemento) {
        mementos.add(newMemento);
    }

    public Memento<T> getMemento(int mementoIndex) {
        return mementos.get(mementoIndex);
    }

}
