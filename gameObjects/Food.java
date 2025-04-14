package gameObjects;

import abstracts.Drawable;
import java.awt.*;
import utils.Coordinates;
import utils.DrawingInformation;

public class Food extends Drawable {

    private boolean deleted = false;   //variabile che indica se stato mangiato inizializzata a false

    public Food(Coordinates coords) {
        super(coords);
    }

    @Override
    public void update() {}

    @Override
    public DrawingInformation draw() {
        if(!this.deleted)
            return new DrawingInformation('f', new Color(144, 238, 144));  //colore verde chiaro
        else
            return new DrawingInformation(' ', Color.BLACK);  //se il cibo viene mangiato lo faccio sparire

    }

    public void markAsDeleted() {
        this.deleted = true;  //Setto "deleted" a true se viene mangiato
    }

    public boolean isDeleted() {
        return this.deleted;   //facio un return di deleted per capire se è stato mangiato oppure no
    }

}
