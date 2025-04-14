package utils;

public class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return (row + ";" + col).hashCode();
    }

    public static boolean isPositionValid(Coordinates coordinates) {
        if(coordinates.getRow() < 0) return false;
        if(coordinates.getCol() < 0) return false;
        if(coordinates.getRow() >= Config.TILE_HEIGHT_LENGTH) return false;
        return coordinates.getCol() < Config.TILE_WIDTH_LENGTH;
    }

}
