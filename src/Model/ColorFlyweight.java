package Model;

import java.util.HashMap;

/**
 *
 * @author Charlie
 */
public class ColorFlyweight {

    HashMap<String, Color> colors;

    public ColorFlyweight() {
        colors = new HashMap<>();
    }

    public Color getColor(String colorValue) {

        Color actualColor;

        //search for reference of color if exists
        if (colors.containsKey(colorValue)) {
            actualColor = colors.get(colorValue);
        } else {
            //if it does not exist recreate the color
            actualColor = new ColorHTML(colorValue);
            colors.put(colorValue, actualColor);
        }

        return actualColor;
    }

}
