package figure.ui;

import figure.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by Areg on 3/26/2017.
 */
public class FigurePanel extends JPanel {
    private ArrayList<Figure> figures;
    private boolean isSelected;
    private int mX;
    private int mY;
    private Thread t;

    public void addFigure(Figure figure) {
        if (figure == null) {
            return;
        }
        figures.add(figure);
        repaint();
    }


    public void removeFigure() {
        if (isSelected) {
            figures.remove(getSelected());
        }
        isSelected = false;
        repaint();
    }

    private Figure getSelected() {
        if (isSelected && figures.size() > 0) {
            return figures.get(figures.size() - 1);
        }
        return null;
    }

    public FigurePanel() {
        figures = new ArrayList<>();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePressedAction(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseDragAction(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    private void handleMouseDragAction(MouseEvent e) {
        if (isSelected) {
            Figure figure = getSelected();
            figure.move(e.getX() - mX, e.getY() - mY);
            repaint();
        }
        mX = e.getX();
        mY = e.getY();

    }

    private void handleMousePressedAction(MouseEvent e) {
        select(e.getX(), e.getY());
        mX = e.getX();
        mY = e.getY();
        if (isSelected) {
            repaint();
        }
    }

    public void select(int x, int y) {
        for (int i = figures.size() - 1; i >= 0; i--) {
            if (figures.get(i).isBelong(x, y)) {
                isSelected = true;
                Figure f = figures.remove(i);
                figures.add(f);
                return;
            }
        }
        isSelected = false;
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(),getHeight());
        for (Figure figure : figures) {
            figure.draw(g);
        }

    }

    public void start() {
        if (isSelected) {
            getSelected().start();
        }
    }

    public void pause(){
        if (isSelected) {
            getSelected().pause();
        }
    }

    public void resume(){
        if (isSelected) {
            getSelected().resume();
        }
    }

    public void stop() {
        if (isSelected) {
            getSelected().stop();
        }
        repaint();
    }
}
