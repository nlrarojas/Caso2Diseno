package Model.strategy;
import Model.TextRepresentation;

public interface IFileSystemStrategy {

    public TextRepresentation loadFile();

    public void saveFile(TextRepresentation text);

    public void setFile(String path);
}
