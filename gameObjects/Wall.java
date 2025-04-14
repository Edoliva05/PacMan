package gameObjects;

import abstracts.Drawable;
import java.awt.*;
import utils.Coordinates;
import utils.DrawingInformation;

public class Wall extends Drawable {


    public Wall(Coordinates coords) {
        super(coords);
    }


    @Override
    public void update() {
    }

    @Override
    public DrawingInformation draw() {
        return new DrawingInformation('w', new Color(138, 43, 226));  //colore viola acceso
    }

}
