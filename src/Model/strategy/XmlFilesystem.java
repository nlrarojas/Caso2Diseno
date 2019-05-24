/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.strategy;

import Model.CharacterRepresentation;
import Model.TextRepresentation;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 *
 * @author Charlie
 */
public class XmlFilesystem implements IFileSystemStrategy{
    private String path;
    
    @Override
    public TextRepresentation loadFile() {  
        TextRepresentation text = new TextRepresentation();
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("char");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                   Element eElement = (Element) nNode;
                   String colorString = eElement.getAttribute("color");
                   boolean isBold = Boolean.parseBoolean(eElement.getAttribute("bold"));
                   text.addText(eElement.getAttribute("char"), colorString);
                }
         }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return text;
    }

    @Override
    public void saveFile(TextRepresentation text) {
        ArrayList<CharacterRepresentation> characters = text.getCharacters();
        try {
            DocumentBuilderFactory dbFactory =
            DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("text");
            doc.appendChild(rootElement);
            
            
            for (int i = 0; i < characters.size(); i++) {
                CharacterRepresentation currChar = characters.get(i);
                
                //create xml element for each char
                Element charNode = doc.createElement("char");
                
                Attr attrColor = doc.createAttribute("color");
                attrColor.setValue(currChar.getColor().getColorAsText());
                
                Attr attrBold = doc.createAttribute("bold");                
                attrColor.setValue( Boolean.toString(currChar.isBold()));
                
                Attr attrChar = doc.createAttribute("char");
                attrChar.setValue(currChar.getText());
                
                charNode.setAttributeNode(attrColor);
                charNode.setAttributeNode(attrBold);
                charNode.setAttributeNode(attrChar);

                rootElement.appendChild(charNode);

            }
            
             // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

            // Output to console for testing
            //StreamResult consoleResult = new StreamResult(System.out);
            //transformer.transform(source, consoleResult);
        
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
