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


    private NotepadFrame() {

        setTitle("Notepad");
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(textArea);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem newMenu = new   JMenuItem("New");
        JMenuItem openMenu = new  JMenuItem("Open");
        JMenuItem saveMenu = new  JMenuItem("Save");
        JMenuItem saveAsMenu =new JMenuItem("Save As");
        JMenuItem exitMenu = new  JMenuItem("Exit");
        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(saveAsMenu);
        fileMenu.add(exitMenu);




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

        add(scrollPane, BorderLayout.CENTER);
        add(menuBar, BorderLayout.NORTH);

        setLocation(0, 0);
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
//                controlPanel.saveAs(pathField.getText(), textArea.getText());
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
//                textArea.setText(controlPanel.open(pathField.getText()));
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
