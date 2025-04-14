package abstracts;

import utils.Coordinates;
import utils.Direction;

abstract public class Controllable extends Drawable {
    public Controllable(Coordinates coordinates) {
        super(coordinates);
    }

    abstract public void move(Direction direction);

}
