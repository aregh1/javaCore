package notepad;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Created by Areg on 8/18/2017.
 */
public class Notepad extends JFrame {
    private JTextArea textArea;

    private Notepad() {
        setTitle("Notepad");
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(textArea);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem newMenu = new JMenuItem("New");
        JMenuItem openMenu = new JMenuItem("Open");
        JMenuItem saveMenu = new JMenuItem("Save");
        JMenuItem saveAsMenu = new JMenuItem("Save As");
        JMenuItem exitMenu = new JMenuItem("Exit");
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

    private void saveActionHandler(ActionEvent event) {
    }

    private void saveAsActionHandler(ActionEvent event) {
        JFileChooser jSaveFileChooser = new JFileChooser();
        jSaveFileChooser.setCurrentDirectory(new File("."));
        int result = jSaveFileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File saveFile = jSaveFileChooser.getSelectedFile();
            saveAs(saveFile.getPath(), textArea.getText());
        }
    }

    private void openActionHandler(ActionEvent e) {
        JFileChooser jOpenFileChooser = new JFileChooser();
        jOpenFileChooser.setCurrentDirectory(new File("."));
        int result = jOpenFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jOpenFileChooser.getSelectedFile();
            textArea.setText(open(selectedFile.getPath()));
        }
    }


    String open(String openPath) {
        FileInputStream in = null;
        BufferedInputStream bfin = null;
        byte[] buf = null;
        try {
            in = new FileInputStream(openPath);
            bfin = new BufferedInputStream(in);
            buf = new byte[in.available()];
            in.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(bfin);
        }
        String text = new String(buf);
        return text;
    }

    void save(String savePath, String filename, String content) {

    }

    void saveAs(String saveAsPath, String content) {
        FileOutputStream out = null;
        BufferedOutputStream bfOut = null;
        File file = new File(saveAsPath);
        try {
            out = new FileOutputStream(file);
            bfOut = new BufferedOutputStream(out);
            bfOut.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(bfOut);
        }
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }
}