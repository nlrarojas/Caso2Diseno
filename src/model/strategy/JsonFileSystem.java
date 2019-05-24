package Model.strategy;

import Model.CharacterRepresentation;
import Model.ColorHTML;
import Model.TextRepresentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileSystem implements IFileSystemStrategy {

    private String path;
    private String info;

    public JsonFileSystem() {

    }

    public TextRepresentation convertStringtoTextRepresentation() {
        TextRepresentation textRepresentation = new TextRepresentation();
        String s = this.info;

        for (int i = 0; i < s.length(); i++) {

            CharacterRepresentation character = new CharacterRepresentation(s.charAt(i), new ColorHTML("#000000"), false);
            textRepresentation.addText(java.lang.Character.toString(s.charAt(i)), null);
        }

        return textRepresentation;
    }

    @Override
    public TextRepresentation loadFile() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach(emp -> parseFileObject((JSONArray) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return convertStringtoTextRepresentation();
    }

    private void parseFileObject(JSONArray employee) {
        employee.forEach(emp -> this.info += (String) emp);
    }

    @Override
    public void saveFile(TextRepresentation pText) {
        ArrayList<CharacterRepresentation> characters = pText.getCharacters();
        JSONArray paragraphs = new JSONArray();
        JSONObject paragraphDetails = new JSONObject();
        String paragraph = "";
        int paragraphCount = 1;

        for (int i = 0; i < characters.size(); i++) {
            char currChar = characters.get(i).getChar();
            paragraph += currChar;

            if (currChar == '.') {
                if (i == characters.size() - 1) {
                    paragraphDetails.put("Paragraph " + paragraphCount, paragraph);
                    paragraphs.add(paragraphDetails);
                } else if (characters.get(i + 1).getChar() == '\n') {
                    paragraphDetails.put("Paragraph " + paragraphCount, paragraph);
                    paragraphs.add(paragraphDetails);
                    paragraphDetails = new JSONObject();
                    paragraphCount += 1;
                    i++;
                }
            }
        }

        try (FileWriter file = new FileWriter(this.path)) {
            file.write(paragraphs.toJSONString());
            file.flush();
        } catch (IOException e) {
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
