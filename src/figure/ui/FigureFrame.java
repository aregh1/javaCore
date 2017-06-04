package figure.ui;

import figure.*;
import figure.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Areg on 3/26/2017.
 */
public class FigureFrame extends JFrame {
    private FigurePanel canvas;

    public FigureFrame() {
        canvas = new FigurePanel();

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
//        JOptionPane.showMessageDialog(this, "Say Hey");
        canvas.addFigure(new Rectangle(30, 30, 50, 40));
        canvas.addFigure(new Circle(30, 30, 40));
    }

    private void removeActionHandler(ActionEvent e) {
//        JOptionPane.showMessageDialog(this, "Say Hey-Hey");
        canvas.removeFigure();
    }

    public static void main(String[] args) {
        new FigureFrame();
    }

}
