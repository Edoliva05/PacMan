package core;

import abstracts.Drawable;
import gameObjects.Food;
import gameObjects.Ghost;
import gameObjects.Player;
import gameObjects.Wall;

public class EventHandler {

    public void handleCollision(Player player, Drawable drawable) {
        if (drawable instanceof Food) handleCollision(player, (Food) drawable);
        if (drawable instanceof Wall) handleCollision(player, (Wall) drawable);
        if (drawable instanceof Ghost) handleCollision(player, (Ghost) drawable);
    }

    public void handleCollision(Player player, Food food) {
        if (food.getCoords().equals(player.getCoords()))
            food.markAsDeleted();
    }

    public void handleCollision(Player player, Wall wall) {
        if (wall.getCoords().equals(player.getCoords()))
            player.resetCoordinates();
    }

    public void handleCollision(Player player, Ghost ghost) {
        player.handleDamage();
    }

}
