package notepad;


import util.FileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Areg on 8/18/2017.
 */
public class Notepad extends JFrame {
    private JTextArea textArea;
    private File file;
    private static final String DEFAULT_FILENAME = "Untitled";

    private Notepad() {
        setTitle(DEFAULT_FILENAME + " - Notepad");
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
                newActionHandler(e);
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
                saveActionHandler(e);
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
                exitActionHandler(e);
            }
        });
        add(scrollPane, BorderLayout.CENTER);
        add(menuBar, BorderLayout.NORTH);

        setLocation(0, 0);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void exitActionHandler(ActionEvent e) {
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void newActionHandler(ActionEvent e) {
        if (isTextSame(file, textArea.getText())) {
            file = null;
            textArea.setText("");
            this.setTitle(DEFAULT_FILENAME + " - Notepad");
        } else {
            String fileName;
            if(file == null){
                fileName = DEFAULT_FILENAME;
            }else {
                fileName = file.getName();
            }
            int selectedOption = JOptionPane.showConfirmDialog(this, "Do you want to save changes to " + fileName,
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (selectedOption) {
                case JOptionPane.CANCEL_OPTION:
                    return;
                case JOptionPane.NO_OPTION:
                    file = null;
                    textArea.setText("");
                    this.setTitle(DEFAULT_FILENAME + " - Notepad");
                    break;
                case JOptionPane.YES_OPTION:
                    saveActionHandler(e);
                    file = null;
                    textArea.setText("");
                    this.setTitle(DEFAULT_FILENAME + " - Notepad");
                    break;
            }
        }
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING && !isTextSame(file, textArea.getText())) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Do you want to save changes to " + file.getName(),
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (selectedOption) {
                case JOptionPane.CANCEL_OPTION:
                    return;
                case JOptionPane.NO_OPTION:
                    System.exit(0);
                    break;
                case JOptionPane.YES_OPTION:
//                    saveActionHandler();
                    System.exit(0);
                    break;

            }
            super.processWindowEvent(e);
        }

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
        if (isTextSame(file, textArea.getText())) {
            JFileChooser jOpenFileChooser = new JFileChooser();
            jOpenFileChooser.setCurrentDirectory(new File("."));
            int result = jOpenFileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jOpenFileChooser.getSelectedFile();
                file = selectedFile;
                textArea.setText(FileUtil.readFileContent(file));
                this.setTitle(file.getName() + " - Notepad");
            }
        } else {String fileName;
            if(file == null){
                fileName = DEFAULT_FILENAME;
            }else {
                fileName = file.getName();
            }
            int selectedOption = JOptionPane.showConfirmDialog(this, "Do you want to save changes to " + fileName,
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (selectedOption) {
                case JOptionPane.CANCEL_OPTION:
                    return;
                case JOptionPane.NO_OPTION:
                    JFileChooser jOpenFileChooser = new JFileChooser();
                    jOpenFileChooser.setCurrentDirectory(new File("."));
                    int result = jOpenFileChooser.showOpenDialog(this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = jOpenFileChooser.getSelectedFile();
                        file = selectedFile;
                        textArea.setText(FileUtil.readFileContent(file));
                        this.setTitle(file.getName() + " - Notepad");
                    }
                    break;
                case JOptionPane.YES_OPTION:
                    saveActionHandler(e);
                    jOpenFileChooser = new JFileChooser();
                    jOpenFileChooser.setCurrentDirectory(new File("."));
                    result = jOpenFileChooser.showOpenDialog(this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = jOpenFileChooser.getSelectedFile();
                        file = selectedFile;
                        textArea.setText(FileUtil.readFileContent(file));
                        this.setTitle(file.getName() + " - Notepad");
                    }
                    break;
            }
        }
    }


    private void saveAs(String saveAsPath, String content) {
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
            FileUtil.close(bfOut);
        }
    }


    private void saveActionHandler(ActionEvent event) {
        if (file == null) {
            saveAsActionHandler(event);
        } else {
            String filePath = file.getPath();
            try {
                Files.delete(file.toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveAs(filePath, textArea.getText());
        }

    }


    private boolean isTextSame(File file, String string) {
        if (file == null) {
            return string.equals("");
        } else {
            FileInputStream fileInputStream = null;
            byte[] buff;
            String fileContent = null;
            try {
                fileInputStream = new FileInputStream(file);
                buff = new byte[fileInputStream.available()];
                fileInputStream.read(buff);
                fileContent = new String(buff);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                FileUtil.close(fileInputStream);
            }
            return fileContent.equals(string);
        }
    }


    public static void main(String[] args) {
        new Notepad();
    }
}