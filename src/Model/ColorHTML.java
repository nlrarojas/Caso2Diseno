/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Charlie
 */
public class ColorHTML implements Color{
    
    private String htmlColor = "#000000";
    
    public ColorHTML(String initialColor){
        
        htmlColor = initialColor;
    }
    
    public String getHtmlColor() {
        return htmlColor;
    }

    public void setHtmlColor(String htmlColor) {
        this.htmlColor = htmlColor;
    }
    
    @Override
    public String getColorAsText() {
        return htmlColor;
    }

}
