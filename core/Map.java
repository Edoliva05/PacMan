package core;

import gameObjects.Wall;
import utils.Config;
import utils.Coordinates;
import utils.Pattern;

import java.util.LinkedList;

public class Map {
    private final LinkedList<Wall> walls;

    private final Pattern[] patterns;

    public Map() {
        walls = new LinkedList<>();
        patterns = new Pattern[]{
                new Pattern(Config.PATTERN_DIMENSION, Config.PATTERN_DIMENSION, new char[][]{
                        {' ', ' ', 'w'},
                        {' ', ' ', ' '},
                        {'w', ' ', 'w'},
                }),
                new Pattern(Config.PATTERN_DIMENSION, Config.PATTERN_DIMENSION, new char[][]{
                        {'w', 'w', 'w'},
                        {'w', ' ', ' '},
                        {'w', ' ', 'w'},
                }),
                new Pattern(Config.PATTERN_DIMENSION, Config.PATTERN_DIMENSION, new char[][]{
                        {'w', ' ', 'w'},
                        {' ', ' ', ' '},
                        {'w', ' ', 'w'},
                }),
                new Pattern(Config.PATTERN_DIMENSION, Config.PATTERN_DIMENSION, new char[][]{
                        {'w', 'w', 'w'},
                        {' ', ' ', ' '},
                        {'w', ' ', 'w'},
                }),
                new Pattern(Config.PATTERN_DIMENSION, Config.PATTERN_DIMENSION, new char[][]{
                        {'w', 'w', 'w'},
                        {' ', ' ', ' '},
                        {'w', 'w', 'w'},
                }),
                new Pattern(Config.PATTERN_DIMENSION, Config.PATTERN_DIMENSION, new char[][]{
                        {'w', 'w', 'w'},
                        {' ', ' ', 'w'},
                        {'w', 'w', 'w'},
                }),
        };

        for (int col = 0; col < Config.TILE_WIDTH_LENGTH; col++) {
            walls.add(new Wall(new Coordinates(0, col)));
            walls.add(new Wall(new Coordinates(Config.TILE_HEIGHT_LENGTH - 1, col)));
        }

        for (int row = 0; row < Config.TILE_HEIGHT_LENGTH; row++) {
            walls.add(new Wall(new Coordinates(row, 0)));
            walls.add(new Wall(new Coordinates(row, Config.TILE_WIDTH_LENGTH - 1)));
        }


        Pattern[][] mapPatterns = new Pattern[Config.PATTERNS_HEIGHT][Config.PATTERNS_WIDTH];

        //Angles
        mapPatterns[0][0] = patterns[0];
        mapPatterns[Config.PATTERNS_HEIGHT - 1][0] = patterns[0].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][Config.PATTERNS_WIDTH - 1] = patterns[0].rotate90degrees().rotate90degrees();
        mapPatterns[0][Config.PATTERNS_WIDTH - 1] = patterns[0].rotate90degrees();

        //External corridor - Layer 1
        mapPatterns[0][1] = patterns[4];
        mapPatterns[0][2] = patterns[3];
        mapPatterns[0][3] = patterns[4];
        mapPatterns[0][4] = patterns[4];
        mapPatterns[0][5] = patterns[4];
        mapPatterns[0][6] = patterns[4];
        mapPatterns[0][7] = patterns[3];
        mapPatterns[0][8] = patterns[4];
        mapPatterns[0][9] = patterns[4];
        mapPatterns[0][10] = patterns[4];
        mapPatterns[0][11] = patterns[3];
        mapPatterns[0][12] = patterns[4];
        mapPatterns[Config.PATTERNS_HEIGHT - 1][1] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][2] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][3] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][4] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][5] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][6] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][7] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][8] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][9] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][10] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][11] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 1][12] = patterns[4].rotate90degrees().rotate90degrees();

        mapPatterns[1][Config.PATTERNS_WIDTH - 1] = patterns[4].rotate90degrees();
        mapPatterns[2][Config.PATTERNS_WIDTH - 1] = patterns[4].rotate90degrees();
        mapPatterns[3][Config.PATTERNS_WIDTH - 1] = patterns[3].rotate90degrees();
        mapPatterns[4][Config.PATTERNS_WIDTH - 1] = patterns[4].rotate90degrees();
        mapPatterns[5][Config.PATTERNS_WIDTH - 1] = patterns[4].rotate90degrees();
        mapPatterns[6][Config.PATTERNS_WIDTH - 1] = patterns[3].rotate90degrees();
        mapPatterns[7][Config.PATTERNS_WIDTH - 1] = patterns[4].rotate90degrees();
        mapPatterns[8][Config.PATTERNS_WIDTH - 1] = patterns[4].rotate90degrees();
        mapPatterns[1][0] = patterns[4].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[2][0] = patterns[4].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[3][0] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[4][0] = patterns[4].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[5][0] = patterns[4].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[6][0] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[7][0] = patterns[4].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[8][0] = patterns[4].rotate90degrees().rotate90degrees().rotate90degrees();
        //Second layer - H
        mapPatterns[1][1] = patterns[0];
        mapPatterns[1][Config.PATTERNS_WIDTH - 2] = patterns[0].rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][1] = patterns[0].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][Config.PATTERNS_WIDTH - 2] = patterns[0].rotate90degrees().rotate90degrees();
        mapPatterns[1][2] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[1][3] = patterns[3];
        mapPatterns[1][4] = patterns[4];
        mapPatterns[1][5] = patterns[4];
        mapPatterns[1][6] = patterns[4];
        mapPatterns[1][7] = patterns[2];
        mapPatterns[1][8] = patterns[4];
        mapPatterns[1][9] = patterns[4];
        mapPatterns[1][10] = patterns[3];
        mapPatterns[1][11] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][2] = patterns[3];
        mapPatterns[Config.PATTERNS_HEIGHT - 2][3] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][4] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][5] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][6] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][7] = patterns[2].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][8] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][9] = patterns[4].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][10] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 2][11] = patterns[3];
        //Second layer - V
        mapPatterns[2][1] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[3][1] = patterns[3].rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][1] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 4][1] = patterns[3].rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 5][1] = patterns[2];
        mapPatterns[4][1] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[2][Config.PATTERNS_WIDTH - 2] = patterns[3].rotate90degrees();
        mapPatterns[3][Config.PATTERNS_WIDTH - 2] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][Config.PATTERNS_WIDTH - 2] = patterns[3].rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 4][Config.PATTERNS_WIDTH - 2] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 5][Config.PATTERNS_WIDTH - 2] = patterns[2];
        mapPatterns[4][Config.PATTERNS_WIDTH - 2] = patterns[3].rotate90degrees();
        //Third layer - H
        mapPatterns[2][2] = patterns[3];
        mapPatterns[2][3] = patterns[2];
        mapPatterns[2][4] = patterns[3];
        mapPatterns[2][5] = patterns[3];
        mapPatterns[2][6] = patterns[3];
        mapPatterns[2][7] = patterns[2];
        mapPatterns[2][8] = patterns[3];
        mapPatterns[2][9] = patterns[3];
        mapPatterns[2][10] = patterns[2];
        mapPatterns[2][11] = patterns[3];
        mapPatterns[Config.PATTERNS_HEIGHT - 3][2] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][3] = patterns[2];
        mapPatterns[Config.PATTERNS_HEIGHT - 3][4] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][5] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][6] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][7] = patterns[2];
        mapPatterns[Config.PATTERNS_HEIGHT - 3][8] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][9] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[Config.PATTERNS_HEIGHT - 3][10] = patterns[2];
        mapPatterns[Config.PATTERNS_HEIGHT - 3][11] = patterns[3].rotate90degrees().rotate90degrees();

        //Third layer - V
        mapPatterns[3][2] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[4][2] = patterns[3].rotate90degrees();
        mapPatterns[5][2] = patterns[2];
        mapPatterns[6][2] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();

        //Fourth layer - H
        mapPatterns[3][3] = patterns[2];
        mapPatterns[3][4] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[3][5] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[3][6] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[3][7] = patterns[2];
        mapPatterns[3][8] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[3][9] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[3][10] = patterns[3].rotate90degrees().rotate90degrees();
        mapPatterns[3][11] = patterns[2];

        mapPatterns[6][3] = patterns[2];
        mapPatterns[6][4] = patterns[3];
        mapPatterns[6][5] = patterns[3];
        mapPatterns[6][6] = patterns[3];
        mapPatterns[6][7] = patterns[2];
        mapPatterns[6][8] = patterns[3];
        mapPatterns[6][9] = patterns[3];
        mapPatterns[6][10] = patterns[3];
        mapPatterns[6][11] = patterns[2];

        //Last layer
        mapPatterns[4][6] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[5][6] = patterns[3].rotate90degrees().rotate90degrees().rotate90degrees();
        mapPatterns[4][8] = patterns[3].rotate90degrees();
        mapPatterns[5][8] = patterns[3].rotate90degrees();
        mapPatterns[4][5] = patterns[5];
        mapPatterns[5][5] = patterns[5];
        mapPatterns[4][9] = patterns[5].rotate90degrees().rotate90degrees();
        mapPatterns[5][9] = patterns[5].rotate90degrees().rotate90degrees();
        mapPatterns[4][4] = patterns[4];
        mapPatterns[5][4] = patterns[4];
        mapPatterns[4][10] = patterns[4];
        mapPatterns[5][10] = patterns[4];
        mapPatterns[4][11] = patterns[2];
        mapPatterns[5][11] = patterns[2];
        mapPatterns[4][3] = patterns[2];
        mapPatterns[5][3] = patterns[2];


        //Center
        mapPatterns[4][7] = patterns[2];
        mapPatterns[5][7] = patterns[2];


        //Rendering
        for (int row = 0; row < Config.PATTERNS_HEIGHT; row++)
            for (int col = 0; col < Config.PATTERNS_WIDTH; col++) {
                Pattern p = mapPatterns[row][col];
                if (p == null)
                    continue;
                for (int pr = 0; pr < p.getWidth(); pr++)
                    for (int pc = 0; pc < p.getHeight(); pc++)
                        if (p.getPattern()[pr][pc] != ' ')
                            walls.add(new Wall(new Coordinates(1 + (row * Config.PATTERN_DIMENSION + pr),
                                    1 + (col * Config.PATTERN_DIMENSION + pc))));
            }

    }

    public LinkedList<Wall> getWalls() {
        return walls;
    }
}
