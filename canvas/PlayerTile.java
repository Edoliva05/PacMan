package canvas;

import utils.Config;

import java.awt.*;

public class PlayerTile extends Tile{

    public PlayerTile(int x, int y, Color color) {
        super(x, y);
        this.setColor(color);
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(this.color);
        g.fillOval(this.row * Config.TILE_DIMENSION, this.col * Config.TILE_DIMENSION, Config.TILE_DIMENSION, Config.TILE_DIMENSION);
    }
}
