package Model.strategy;

import Model.CharacterRepresentation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Model.TextRepresentation;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfFileSystem implements IFileSystemStrategy {

    private String path;

    public PdfFileSystem() {

    }

    @Override
    public TextRepresentation loadFile() {

        try {
            File file = new File(path);
            PDDocument document = PDDocument.load(file);
            //PDPage page = document.getPage(1);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            document.close();

            TextRepresentation textRep = new TextRepresentation();
            textRep.addText(text, "#000000");

            return textRep;

        } catch (IOException ex) {
            Logger.getLogger(PdfFileSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveFile(TextRepresentation pText) {

        ArrayList<CharacterRepresentation> characters = pText.getCharacters();

        try {
            PDDocument document = new PDDocument();
            PDPage new_page = new PDPage();
            document.addPage(new_page);

            PDPageContentStream contentStream = new PDPageContentStream(document, new_page);

            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(14.5f, 700);
            contentStream.setLeading(14.5f);
            //contentStream.newLine();
            for (int i = 0; i < characters.size(); i++) {
                CharacterRepresentation currChar = characters.get(i);
                contentStream.setStrokingColor(Color.decode(currChar.getColor().getColorAsText()));
                contentStream.showText(currChar.getText());

            }
            contentStream.endText();
            contentStream.close();

            document.save(path);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFile(String pPath) {
        this.path = pPath;
        File file = new File(pPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
