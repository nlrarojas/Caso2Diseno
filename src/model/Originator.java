/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.memento;

public class Originator <T>{
    private T state;
    

    public void set(T newState){
        state = newState;
    }
    
    public Memento saveToMemento(){
        return new Memento(state);
    }
    
    public void restoreFromMemento(Memento<T> targetMemento){
        this.state = targetMemento.getState();
    }
}
