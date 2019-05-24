package Model.strategy;

/**
 *
 * @author Charlie
 */
public class FileSystemFactory {

    public IFileSystemStrategy create(String type) {
        switch (type) {
            case IFileSystemStrategy.TXT_FILE:
                break;
            case IFileSystemStrategy.TXT_TAB:
                break;
            case IFileSystemStrategy.JSON_FILE:
                break;
            case IFileSystemStrategy.XML_FILE:
                break;
            case IFileSystemStrategy.CSV_FILE:
                break;
            case IFileSystemStrategy.PDF_FILE:
                break;
            default:

        }
        return null;
    }

}
