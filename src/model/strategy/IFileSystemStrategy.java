package Model.strategy;

import Model.TextRepresentation;

public interface IFileSystemStrategy {
    
    public static final String TXT_FILE = "TXT_FILE";
    public static final String TXT_TAB = "TXT_TAB";
    public static final String JSON_FILE = "JSON_FILE";
    public static final String XML_FILE = "XML_FILE";
    public static final String CSV_FILE = "CSV_FILE";
    public static final String PDF_FILE = "PDF_FILE";

    public TextRepresentation loadFile();

    public void saveFile(TextRepresentation text);

    public void setFile(String path);
}
