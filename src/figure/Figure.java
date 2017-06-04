package figure;

import java.awt.*;

/**
 * Created by Areg on 3/25/2017.
 */
public abstract class Figure {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Figure(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void move(int dx, int dy){
        this.x = x + dx;
        this.y = y + dy;
    }

    public abstract void draw(Graphics g);
    public abstract boolean isBelong(int x, int y);
}
