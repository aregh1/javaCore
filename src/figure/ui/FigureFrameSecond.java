package figure.ui;

import figure.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Areg on 4/8/2017.
 */
public class FigureFrameSecond extends JFrame {
    private FigurePanelSecond canvas;
    public FigureFrameSecond() {
        canvas = new FigurePanelSecond();

        JPanel controlPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addActionHandler(e);
            }
        });
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionHandler(e);
            }
        });
        controlPanel.add(addButton);
        controlPanel.add(removeButton);


        add(controlPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        setLocation(-7, 0);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }
    private void addActionHandler(ActionEvent e) {
        canvas.addFigure(new figure.Rectangle(30, 30, 50, 40));
        canvas.addFigure(new Circle(30, 30, 40));
    }

    private void removeActionHandler(ActionEvent e) {
        canvas.removeFigure();
    }

    public static void main(String[] args) {
        new FigureFrame();
    }




}
