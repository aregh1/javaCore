package figure.ui;

import figure.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by Areg on 4/8/2017.
 */
public class FigurePanelSecond extends JPanel {
    private ArrayList<Figure> figuries;
    private boolean isSelected;
    private int mX;
    private int mY;
    public void addFigure(Figure figure) {
        if (figure == null) {
            return;
        }
        figuries.add(figure);
        repaint();
    }

    public void removeFigure(){
        if(isSelected){
            figuries.remove(getSelected());
        }
        isSelected = false;
        repaint();
    }
    private Figure getSelected() {
        if (isSelected && figuries.size() > 0) {
            return figuries.get(figuries.size() - 1);
        }
        return null;
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
    private void select(int x, int y) {
       for(int i = figuries.size() - 1; i >= 0; i--){
           if (figuries.get(i).isBelong(x, y)) {
               isSelected = true;
               Figure f = figuries.remove(i);
               figuries.add(f);
               return;
           }
       }
        isSelected = false;
    }


    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, 1000, 1000);
        for (Figure figure : figuries) {
            figure.draw(g);
        }

    }
    public FigurePanelSecond() {
        figuries = new ArrayList<>();

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







}
