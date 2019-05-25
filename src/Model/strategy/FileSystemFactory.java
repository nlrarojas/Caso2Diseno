package Model.strategy;

/**
 *
 * @author Charlie
 */
public class FileSystemFactory {

    public IFileSystemStrategy create(String type) {
        switch (type) {
            case IFileSystemStrategy.TXT_FILE:
                return new TxtFileSystem();
            case IFileSystemStrategy.TXT_TAB:
                return new TxtTabSystem();
            case IFileSystemStrategy.JSON_FILE:
                return new JsonFileSystem();
            case IFileSystemStrategy.XML_FILE:
                return new XmlFilesystem();
            case IFileSystemStrategy.CSV_FILE:
                return new CsvFileSystem();
            case IFileSystemStrategy.PDF_FILE:
                return new PdfFileSystem();
            default:

        }
        return null;
    }

}
