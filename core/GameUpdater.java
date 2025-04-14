package core;

import abstracts.Drawable;
import gameObjects.Food;
import gameObjects.Ghost;
import gameObjects.Player;
import gameObjects.Wall;
import utils.Config;
import utils.Coordinates;
import utils.Direction;
import utils.DrawingInformation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static utils.Config.*;

public class GameUpdater implements KeyListener {

    private Direction playerDirection;
    private final Player player;
    private final LinkedList<Food> food;
    private final LinkedList<Ghost> ghosts;
    private final LinkedList<Drawable> drawables;
    private final EventHandler eventHandler;
    private final Map map;

    public GameUpdater() {
        playerDirection = Direction.STAY;
        player = new Player(MIDDLE_COORDINATES);

        food = new LinkedList<>();
        ghosts = new LinkedList<>();
        ghosts.add(new Ghost(new Coordinates(1, 1)));
        ghosts.add(new Ghost(new Coordinates(1, TILE_WIDTH_LENGTH - 2)));
        ghosts.add(new Ghost(new Coordinates(TILE_HEIGHT_LENGTH - 2, 1)));
        ghosts.add(new Ghost(new Coordinates(TILE_HEIGHT_LENGTH - 2, TILE_WIDTH_LENGTH - 2)));

        map = new Map();

        for (Coordinates coords : getFoodCoords())
            food.add(new Food(coords));

        drawables = new LinkedList<>();
        eventHandler = new EventHandler();
    }

    private DrawingInformation[][] getVoidMatrix() {
        DrawingInformation[][] gameMatrix = new DrawingInformation[Config.TILE_HEIGHT_LENGTH][Config.TILE_WIDTH_LENGTH]; //Prima la riga, poi la colonna!
        for (int i = 0; i < Config.TILE_HEIGHT_LENGTH; i++)
            for (int j = 0; j < Config.TILE_WIDTH_LENGTH; j++)
                gameMatrix[i][j] = new DrawingInformation(' ', Color.BLACK);
        return gameMatrix;
    }

    public DrawingInformation[][] update() {
        DrawingInformation[][] gameMatrix = getVoidMatrix();
        drawables.clear();
        drawables.addAll(food);
        drawables.add(player);
        drawables.addAll(ghosts);
        drawables.addAll(map.getWalls());
        player.move(playerDirection);

        if (player.isWinner()) {
            System.out.println("WIN!");
            this.draw(gameMatrix);
            return gameMatrix;
        }

        if(player.isLooser()){
            System.out.println("LOSE!");
            this.draw(gameMatrix);
            return gameMatrix;
        }

        for (Ghost ghost : ghosts) {
            Direction[] dirs = getGhostsAvailableDirections(ghost.getCoords(), map.getWalls());
            ghost.setAvailDirections(new ArrayList<>(List.of(dirs)));
        }

        if(!this.checkUneatenFood())
            player.markAsWinner();

        for (Drawable d : drawables) {
            d.update();
            if (player.getCoords().equals(d.getCoords()))
                eventHandler.handleCollision(player, d);
        }


        playerDirection = Direction.STAY;
        //Retrieving symbols
        this.draw(gameMatrix);
        return gameMatrix;
    }

    private boolean checkUneatenFood() {
        for (Food f : food)
            if (!f.isDeleted())
                return true;
        return false;
    }

    private Direction[] getGhostsAvailableDirections(Coordinates ghostCoords, LinkedList<Wall> walls) {
        HashMap<Coordinates, Direction> map = new HashMap<>();
        map.put(new Coordinates(ghostCoords.getRow() - 1, ghostCoords.getCol()), Direction.UP);
        map.put(new Coordinates(ghostCoords.getRow() + 1, ghostCoords.getCol()), Direction.DOWN);
        map.put(new Coordinates(ghostCoords.getRow(), ghostCoords.getCol() - 1), Direction.LEFT);
        map.put(new Coordinates(ghostCoords.getRow(), ghostCoords.getCol() + 1), Direction.RIGHT);


        LinkedList<Coordinates> toRemove = new LinkedList<>();

        for (Wall wall : walls)
            for (Coordinates coordinates : map.keySet())
                if (wall.getCoords().equals(coordinates) || !Coordinates.isPositionValid(coordinates))
                    toRemove.add(coordinates);

        for (Coordinates coordinates : toRemove)
            map.remove(coordinates);

        return map.values().toArray(Direction[]::new);
    }

    private LinkedList<Coordinates> getFoodCoords() {
        LinkedList<Coordinates> foodCoords = new LinkedList<>();
        ArrayList<Coordinates> usedCoords = new ArrayList<>();
        usedCoords.add(player.getCoords());
        for (Wall wall : map.getWalls())
            usedCoords.add(wall.getCoords());
        for (Ghost ghost : ghosts)
            usedCoords.add(ghost.getCoords());


        for (int row = 0; row < Config.TILE_HEIGHT_LENGTH; row++)
            for (int col = 0; col < Config.TILE_WIDTH_LENGTH; col++)
                if (!usedCoords.contains(new Coordinates(row, col)))
                    foodCoords.add(new Coordinates(row, col));
        return foodCoords;
    }

    public void draw(DrawingInformation[][] gameMatrix) {
        for (Drawable d : drawables) {
            DrawingInformation drawing = d.draw();
            if (drawing.getSymbol() == ' ')
                continue;
            if(!Coordinates.isPositionValid(d.getCoords()))
                continue;
            int x = d.getCoords().getRow();
            int y = d.getCoords().getCol();

            gameMatrix[x][y] = drawing;
        }
    }

    public int getPlayerLife(){
        return this.player.getLife();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                playerDirection = Direction.UP;
                break;
            case KeyEvent.VK_A:
                playerDirection = Direction.LEFT;
                break;
            case KeyEvent.VK_S:
                playerDirection = Direction.DOWN;
                break;
            case KeyEvent.VK_D:
                playerDirection = Direction.RIGHT;
                break;
            default:
                playerDirection = Direction.STAY;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
