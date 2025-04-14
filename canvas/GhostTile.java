package canvas;

import utils.Config;

import java.awt.*;

public class GhostTile extends Tile{

    public GhostTile(int x, int y, Color color) {
        super(x, y);
        this.setColor(color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(this.color);
        g.fillOval(this.row * Config.TILE_DIMENSION + 2,
                this.col * Config.TILE_DIMENSION,
                (Config.TILE_DIMENSION / 2),
                (Config.TILE_DIMENSION / 2));

        Rectangle r = new Rectangle(this.row * Config.TILE_DIMENSION  + 2,
                this.col * Config.TILE_DIMENSION + 4,
                (Config.TILE_DIMENSION / 2),
                (Config.TILE_DIMENSION / 2));
        g.setColor(this.color);
        g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
    }
}
