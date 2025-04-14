package canvas;

import utils.Config;
import utils.Coordinates;
import utils.DrawingInformation;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TileDrawer extends JPanel {
    private final HashMap<Coordinates, Tile> tiles;
    private DrawingInformation[][] frame = null;

    public TileDrawer() {
        tiles = new HashMap<>();
        for (int row = 0; row < Config.TILE_HEIGHT_LENGTH; row++)
            for (int col = 0; col < Config.TILE_WIDTH_LENGTH; col++)
                tiles.put(new Coordinates(row, col), new Tile(row, col));

    }

    private Tile handleTile(int col, int row, DrawingInformation drawingInformation) {
        switch (drawingInformation.getSymbol()) {
            case 'P':
                return new PlayerTile(row, col, drawingInformation.getColor());
            case 'G':
                return new GhostTile(row, col, drawingInformation.getColor());
            case 'f':
                return new FoodTile(row, col, drawingInformation.getColor());
            case 'w':
                return new WallTile(row, col, drawingInformation.getColor());
            default:
                return new Tile(row, col);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw();
        for (int row = 0; row < Config.TILE_HEIGHT_LENGTH; row++)
            for (int col = 0; col < Config.TILE_WIDTH_LENGTH; col++) {
                if (tiles.get(new Coordinates(row, col)) != null) //Tile exists
                    tiles.get(new Coordinates(row, col)).draw(g);
            }
    }

    private void draw() {
        if (frame == null)
            return;

        for (int row = 0; row < Config.TILE_HEIGHT_LENGTH; row++)
            for (int col = 0; col < Config.TILE_WIDTH_LENGTH; col++) {
                tiles.replace(new Coordinates(row, col), handleTile(row, col, frame[row][col]));
            }

    }

    public void sendFrame(DrawingInformation[][] frame) {
        this.frame = frame;
    }
}
