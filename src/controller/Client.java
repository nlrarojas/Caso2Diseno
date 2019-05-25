package controller;

import Model.CareTaker;
import Model.Memento;
import Model.Originator;
import Model.TextRepresentation;
import java.io.File;

/**
 *
 * @author Nelson
 */
public class Client {
    Originator<TextRepresentation> texOriginator; 
    CareTaker<TextRepresentation> history;
    private int pointer =0;
    
    public Client(){
        texOriginator = new Originator<TextRepresentation>();
        TextRepresentation newState = new TextRepresentation();
        texOriginator.set(newState);
        history = new CareTaker<TextRepresentation>();
        history.addMemento(texOriginator.saveToMemento());
        
    }
    
    public void openFile(File file) {
        
    }
    
    public void saveFile(File file, TextRepresentation textRepresentation) {
        
    }
    
    public void undo() {
        if(pointer <= 0) return;
        
        Memento targetMemento = history.getMemento(pointer);
        texOriginator.restoreFromMemento(targetMemento);
        pointer--;
    }
    
    public void redo() {
        if(pointer >= history.getTop()) return;
        
        Memento targetMemento = history.getMemento(pointer+1);
        texOriginator.restoreFromMemento(targetMemento);
        pointer++;
    }
    
    public void copy() {
        
    }
    
    public void cut() {
        
    }
    
    public void paste() {
        
    }
    
}
