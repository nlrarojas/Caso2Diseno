/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class CareTaker<T> {
    ArrayList<Memento<T>> mementos;

    public void addMemento(Memento<T> newMemento){
        mementos.add(newMemento);
    }
    
    public Memento<T> getMemento(int mementoIndex){
        
        return mementos.get(mementoIndex);
    }

}
