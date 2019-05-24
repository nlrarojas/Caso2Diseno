/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Charlie
 */
public class ColorFlyweight {
    HashMap<String,Color> colors;

    public ColorFlyweight() {
        colors = new HashMap<String,Color>();
    
    }
    
    
    public Color getColor(String colorValue){
        
        Color actualColor = null; 
  
        //search for reference of color if exists
        if (colors.containsKey(colorValue)) 
                actualColor = colors.get(colorValue); 
        else
        {   
            //if it does not exist recreate the color
            actualColor = new ColorHTML(colorValue);
            colors.put(colorValue, actualColor);
        }
        
        return actualColor;
    }
    
}
