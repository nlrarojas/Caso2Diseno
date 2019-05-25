package controller;

import Model.CareTaker;
import Model.Memento;
import Model.Originator;
import Model.TextRepresentation;
import Model.strategy.FileSystemFactory;
import Model.strategy.IFileSystemStrategy;
import java.io.File;
import java.util.Optional;

/**
 *
 * @author Nelson
 */
public class Client {

    Originator<TextRepresentation> texOriginator;
    CareTaker<TextRepresentation> history;
    private int pointer = 0;
    FileSystemFactory factory;
    

    public Client() {
        texOriginator = new Originator<>();
        TextRepresentation newState = new TextRepresentation();
        texOriginator.set(newState);
        history = new CareTaker<>();
        history.addMemento(texOriginator.saveToMemento());

        factory = new FileSystemFactory();
    }

    public TextRepresentation openFile(File file) {
        String extension = "";
        int i = file.getName().lastIndexOf('.');
        if (i > 0) {
            extension = file.getName().substring(i+1);
        }
        
        IFileSystemStrategy fileSystem = factory.create(extension);
        fileSystem.setFile(file.getPath());
        TextRepresentation representation = fileSystem.loadFile();
        texOriginator.set(representation);
        return representation;
    }
    
    public void saveFile(File file) {     
        String extension = "";
        int i = file.getName().lastIndexOf('.');
        if (i > 0) {
            extension = file.getName().substring(i+1);
        }
        
        IFileSystemStrategy fileSystem = factory.create(extension);
        fileSystem.setFile(file.getPath());
        fileSystem.saveFile((TextRepresentation) texOriginator.saveToMemento().getState());
    }

    public TextRepresentation undo() {
        if (pointer <= 0) {
            return new TextRepresentation();
        }

        Memento targetMemento = history.getMemento(pointer);
        texOriginator.restoreFromMemento(targetMemento);
        pointer--;
        return (TextRepresentation) targetMemento.getState();
    }

    public TextRepresentation redo() {
        if (pointer >= history.getTop()) {
            return new TextRepresentation();
        }

        Memento targetMemento = history.getMemento(pointer + 1);
        texOriginator.restoreFromMemento(targetMemento);
        pointer++;
        return (TextRepresentation) targetMemento.getState();
    }

    public void copy() {

    }

    public void cut() {

    }

    public void paste() {

    }
    
    public void update(String text) {        
        TextRepresentation representation = new TextRepresentation();
        representation.addText(text, "#000000");
        texOriginator.set(representation);
        history.addMemento(texOriginator.saveToMemento());        
        pointer = history.getTop();
    }

    public Originator<TextRepresentation> getTexOriginator() {
        return texOriginator;
    }

    public void setTexOriginator(Originator<TextRepresentation> texOriginator) {
        this.texOriginator = texOriginator;
    }

    
    
}
