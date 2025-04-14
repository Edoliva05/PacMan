package canvas;

import utils.Config;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    protected final int row;
    protected final int col;
    protected Color color;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        color = Color.BLACK;
    }

    public void draw(Graphics g) {
        Rectangle r = new Rectangle(this.row * Config.TILE_DIMENSION, this.col * Config.TILE_DIMENSION, Config.TILE_DIMENSION, Config.TILE_DIMENSION);
        g.setColor(Color.BLACK);
        g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
