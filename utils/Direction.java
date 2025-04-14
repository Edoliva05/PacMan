package utils;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    STAY;


    public static Direction getOpposite(Direction direction) {
        if (direction == Direction.UP) return Direction.DOWN;
        if (direction == Direction.DOWN) return Direction.UP;
        if (direction == Direction.LEFT) return Direction.RIGHT;
        if (direction == Direction.RIGHT) return Direction.LEFT;
        return Direction.STAY;
    }
}