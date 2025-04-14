package utils;

import java.awt.*;

public class DrawingInformation {

    private char symbol;
    private Color color;

    public DrawingInformation(char symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public char getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }
}
