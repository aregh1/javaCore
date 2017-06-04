package figure;

import java.awt.*;

/**
 * Created by Areg on 3/25/2017.
 */
public class Rectangle extends Figure {
    static final Color DEFUALT_COLOR = Color.BLUE;

    public Rectangle(int x, int y, int width, int height ) {
        this(x, y, width, height, DEFUALT_COLOR);
    }
    public Rectangle(int x, int y, int width, int height, Color color ) {
        super(x, y, width, height, color);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public boolean isBelong(int x, int y) {
        return getX() <= x && x <= getX() + getWidth()
                && getY() <= y && y <= getY() + getHeight();
    }


}
