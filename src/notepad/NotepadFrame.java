package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Areg on 8/18/2017.
 */
public class NotepadFrame extends JFrame {
    private JTextArea textArea;
    private NotepadPanel controlPanel;

    private NotepadFrame() {
        controlPanel = new NotepadPanel();
        setTitle("Notepad");
        textArea = new JTextArea();
        add(textArea);
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.add(fileMenu);
        MenuItem newMenu = new MenuItem("New");
        MenuItem openMenu = new MenuItem("Open");
        MenuItem saveMenu = new MenuItem("Save");
        MenuItem saveAsMenu = new MenuItem("Save As");
        MenuItem exitMenu = new MenuItem("Exit");
        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(saveAsMenu);
        fileMenu.add(exitMenu);

        setMenuBar(menuBar);

        newMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        openMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openActionHandler(e);
            }
        });
        saveMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveAsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsActionHandler(e);
            }
        });
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea.getText() == "") {
                    System.exit(0);
                } else {
//                    saveActionHandler();
                }
            }
        });


        setLocation(-7, 0);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void saveActionHandler(ActionEvent event) {}

    private void saveAsActionHandler(ActionEvent event) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        JButton saveAs = new JButton("Save As");
        JTextField pathField = new JTextField("Pathname");
        panel.add(saveAs, BorderLayout.CENTER);
        frame.add(pathField, BorderLayout.NORTH);
        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlPanel.saveAs(pathField.getText(), textArea.getText());
            }
        });
        frame.setLocation(500, 500);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void openActionHandler(ActionEvent e) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        JButton open = new JButton("Open");
        JTextField pathField = new JTextField("Pathname");
        panel.add(open, BorderLayout.CENTER);
        frame.add(pathField, BorderLayout.NORTH);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(controlPanel.open(pathField.getText()));
            }
        });
        frame.setLocation(500, 500);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new NotepadFrame();
    }

}
