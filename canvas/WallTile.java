package canvas;

import utils.Config;

import java.awt.*;

public class WallTile extends Tile {

    public WallTile(int x, int y, Color color) {
        super(x, y);
        this.setColor(color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        //color = new Color(0, 34, 150);
        g.setColor(this.color);
        Rectangle r = new Rectangle(this.row * Config.TILE_DIMENSION,
                this.col * Config.TILE_DIMENSION,
                (Config.TILE_DIMENSION - 2) / 2,
                (Config.TILE_DIMENSION - 2) / 2);
        g.setColor(this.color);
        g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());

        r = new Rectangle(this.row * Config.TILE_DIMENSION + (Config.TILE_DIMENSION) / 2,
                this.col * Config.TILE_DIMENSION,
                (Config.TILE_DIMENSION - 2) / 2,
                (Config.TILE_DIMENSION - 2) / 2);
        g.setColor(this.color);
        g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());

        r = new Rectangle(this.row * Config.TILE_DIMENSION,
                this.col * Config.TILE_DIMENSION + (Config.TILE_DIMENSION) / 2,
                (Config.TILE_DIMENSION - 2) / 2,
                (Config.TILE_DIMENSION - 2) / 2);
        g.setColor(this.color);
        g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());

        r = new Rectangle(this.row * Config.TILE_DIMENSION + (Config.TILE_DIMENSION) / 2,
                this.col * Config.TILE_DIMENSION + (Config.TILE_DIMENSION) / 2,
                (Config.TILE_DIMENSION - 2) / 2,
                (Config.TILE_DIMENSION - 2) / 2);
        g.setColor(this.color);
        g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
    }
}
