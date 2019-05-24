/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Charlie
 */
public class Memento<T> {
    private T state;
    
    public Memento(T initialState){
        state = initialState;
    }
    
    public void memento(T newState){
        state = newState;
    }
    
    public T getState(){
        return state;
    }
}
