package utils;

public class Config {
    public static final int WINDOW_WIDTH = 880;
    public static final int WINDOW_HEIGHT = 640;
    public static final int TILE_DIMENSION = 20;
    public static final int TILE_WIDTH_LENGTH = WINDOW_WIDTH / TILE_DIMENSION;
    public static final int TILE_HEIGHT_LENGTH = WINDOW_HEIGHT / TILE_DIMENSION;
    public static final Coordinates MIDDLE_COORDINATES = new Coordinates(TILE_HEIGHT_LENGTH / 2 + 1, TILE_WIDTH_LENGTH / 2 + 1);
    public static final int UPDATE_DELAY = 100;
    public static final int DRAWING_RESET_COUNT_DELAY = 1000;
    public static final int PATTERN_DIMENSION = 3;
    public static final int PATTERNS_WIDTH = (TILE_WIDTH_LENGTH - 2) / PATTERN_DIMENSION;
    public static final int PATTERNS_HEIGHT = (TILE_HEIGHT_LENGTH - 2) / PATTERN_DIMENSION;
}
