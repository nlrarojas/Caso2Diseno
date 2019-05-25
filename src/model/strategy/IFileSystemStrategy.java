package Model.strategy;

import Model.TextRepresentation;

public interface IFileSystemStrategy {
    
    public static final String TXT_FILE = "txt";
    public static final String TXT_TAB = "txt2";
    public static final String JSON_FILE = "json";
    public static final String XML_FILE = "xml";
    public static final String CSV_FILE = "csv";
    public static final String PDF_FILE = "pdf";

    public TextRepresentation loadFile();

    public void saveFile(TextRepresentation text);

    public void setFile(String path);    
}
