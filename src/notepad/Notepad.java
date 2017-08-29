package notepad;


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
    private String fileName;
    private static final String DEFAULT_FILENAME = "Untitled";

    private Notepad() {
        fileName = DEFAULT_FILENAME;
        setTitle(fileName + " - Notepad");
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

//                    JFrame askingForSaveFrame = new JFrame("Notepad");
//                    JLabel theQuestion = new JLabel("Do you want to save changes to " + fileName);
//                    askingForSaveFrame.add(theQuestion, BorderLayout.CENTER);
//                    JPanel actionPanel = new JPanel();
//                    JButton saveButton = new JButton("Save");
//                    JButton dontSaveButton = new JButton("Don't Save");
//                    JButton cancelButton = new JButton("Cancel");
//                    actionPanel.add(saveButton);
//                    actionPanel.add(dontSaveButton);
//                    actionPanel.add(cancelButton);
//                    askingForSaveFrame.add(actionPanel, BorderLayout.SOUTH);
//                    saveButton.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            saveActionHandler(e);
//                        }
//                    });
//                    dontSaveButton.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            System.exit(0);
//                        }
//                    });
//                    cancelButton.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            // Question
//                        }
//                    });
//                    askingForSaveFrame.setLocation(400, 400);
//                    askingForSaveFrame.setSize(400, 200);
//                    askingForSaveFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//                    askingForSaveFrame.setVisible(true);
//                }
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

        if (true) {
            fileName = DEFAULT_FILENAME;
            file = null;
            textArea.setText("");
        } else {
            JFrame askingForSave = new JFrame("Notepad");
            JLabel theQuestion = new JLabel("Do you want to save changes to " + fileName);
            askingForSave.add(theQuestion, BorderLayout.CENTER);
            JPanel actionPanel = new JPanel();
            JButton saveButton = new JButton("Save");
            JButton dontSaveButton = new JButton("Don't Save");
            JButton cancelButton = new JButton("Cancel");
            actionPanel.add(saveButton);
            actionPanel.add(dontSaveButton);
            actionPanel.add(cancelButton);
            askingForSave.add(actionPanel, BorderLayout.SOUTH);
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveActionHandler(e);
                    fileName = DEFAULT_FILENAME;
                    file = null;
                    textArea.setText("");
                }
            });
            dontSaveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fileName = DEFAULT_FILENAME;
                    file = null;
                    textArea.setText("");
                }
            });
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Question
                }
            });
            askingForSave.setLocation(400, 400);
            askingForSave.setSize(400, 200);
            askingForSave.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            askingForSave.setVisible(true);
        }
    }

//    @Override
//    protected void processWindowEvent(WindowEvent e) {
//        String fileContent = readFileContent(file);
//        if (e.getID() == WindowEvent.WINDOW_CLOSING && fileContent != textArea.getText()) {
//            int selectedOption = JOptionPane.showConfirmDialog(this, "Do you want to save changes to " + fileName,
//                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
//            switch (selectedOption) {
//                case JOptionPane.CANCEL_OPTION:
//                    return;
//                case JOptionPane.NO_OPTION:
////                    JOptionPane.showMessageDialog(this, "NO_OPTION is selected");
//                    System.exit(0);
//                    break;
//                case JOptionPane.YES_OPTION:
//
//            }
//            super.processWindowEvent(e);
//        }
//
//    }

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
        if (file == null) {
            String noFileContent = textArea.getText();
            String nothing = "";
            if (noFileContent == nothing) {
                JFileChooser jOpenFileChooser = new JFileChooser();
                jOpenFileChooser.setCurrentDirectory(new File("."));
                int result = jOpenFileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jOpenFileChooser.getSelectedFile();
                    file = selectedFile;
                    fileName = file.getName();
                    textArea.setText(open(selectedFile.getPath()));
                    this.setTitle(fileName + " - Notepad");
                }
            } else {
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
                            fileName = file.getName();
                            textArea.setText(open(selectedFile.getPath()));
                            this.setTitle(fileName + " - Notepad");
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
                            fileName = file.getName();
                            textArea.setText(open(selectedFile.getPath()));
                            this.setTitle(fileName + " - Notepad");
                        }
                        break;
                }
            }
        } else {
            String fileContent = readFileContent(file);
            if (fileContent == textArea.getText()) {
                JFileChooser jOpenFileChooser = new JFileChooser();
                jOpenFileChooser.setCurrentDirectory(new File("."));
                int result = jOpenFileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jOpenFileChooser.getSelectedFile();
                    file = selectedFile;
                    fileName = file.getName();
                    textArea.setText(open(selectedFile.getPath()));
                    this.setTitle(fileName + " - Notepad");
                }
            } else {
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
                            fileName = file.getName();
                            textArea.setText(open(selectedFile.getPath()));
                            this.setTitle(fileName + " - Notepad");
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
                            fileName = file.getName();
                            textArea.setText(open(selectedFile.getPath()));
                            this.setTitle(fileName + " - Notepad");
                        }
                        break;
                }
            }
        }
    }


    private String readFileContent(File file) {
        FileInputStream fileInputStream = null;
        byte[] buff = null;
        String fileContent = null;
        try {
            fileInputStream = new FileInputStream(file);
            buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            fileContent = new String(buff);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            close(fileInputStream);
        }
        return fileContent;
    }

    private String open(String openPath) {
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
            close(bfOut);
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

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//    public static List<File> search(File dirToSearchIn, String fileNameMask) {
//        //TODO
//        List<File> resultList = new ArrayList<>();
//        search0(resultList, dirToSearchIn, fileNameMask);
//        return resultList;
//    }
//
//    private static void search0(List<File> resultList, File dirTosearchIn, String fileNameMask) {
//        //TODO  complete recoursively
//    }

    public static void main(String[] args) {
        new Notepad();
    }
}