package figure;

import figure.ui.FigurePanel;

import java.awt.*;

/**
 * Created by Areg on 3/25/2017.
 */
public class Circle extends Figure {
    public static final Color DEFAULT_COLOR = Color.YELLOW;

    public Circle(int x, int y, int diagonal, FigurePanel canvas) {
        this(x, y, diagonal, canvas, DEFAULT_COLOR);
    }

    public Circle(int x, int y, int diagonal, FigurePanel canvas, Color color) {
        super(x, y, diagonal, diagonal, canvas, color);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    public boolean isBelong(int x, int y) {
        double radius = getHeight() / 2.;
        return Math.pow(getX() + radius - x, 2) + Math.pow(getY() + radius - y, 2) <= radius * radius;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getHeight(), getHeight());
    }


}
