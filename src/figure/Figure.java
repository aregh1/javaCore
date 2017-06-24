package figure;

import figure.ui.FigurePanel;
import sun.awt.SunToolkit;

import java.awt.*;

/**
 * Created by Areg on 3/25/2017.
 */
public abstract class Figure implements Runnable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private FigurePanel canvas;

    private Thread t;
    private volatile boolean isRunning = false;

    private int dX;
    private int dY;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public FigurePanel getCanvas() {
        return canvas;
    }

    public Figure(int x, int y, int width, int height, FigurePanel canvas, Color color) {
        this.canvas = canvas;

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

    public void move(int dx, int dy) {
        this.x = x + dx;
        this.y = y + dy;
    }

    @Override
    public void run() {
        while (isRunning) {
            move(dX, dY);
            canvas.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void checkDirection() {

    }

    public void start() {
        if (t != null) {
            try {
                stop();
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            isRunning = true;
            dX = 3;
            dY = 3;
            t = new Thread(this);
            t.start();
        } catch (IllegalThreadStateException e) {
            e.printStackTrace();
        }

    }

    public void stop() {
        isRunning = false;
    }

    public abstract void draw(Graphics g);

    public abstract boolean isBelong(int x, int y);
}
