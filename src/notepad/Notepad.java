package notepad;


import bracechecker.BraceChecker;
import chapter7.io.fileclass.StreamDemo;
import notepad.util.UnderlineHighlighter;
import util.FileUtil;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;

/**
 * Created by Areg on 8/18/2017.
 */
public class Notepad extends JFrame {
    private BraceChecker braceChecker;
    private JTextArea textArea;
    private File file;
    private static final String DEFAULT_FILENAME = "Untitled";

    private Notepad() throws IOException {
        setTitle(DEFAULT_FILENAME + " - Notepad");
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(textArea);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkBrackets();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkBrackets();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(new NotepadMenuBar(this), BorderLayout.NORTH);

        setLocation(0, 0);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void checkBrackets() {
        if (braceChecker == null) {
            braceChecker = new BraceChecker();
        }
        String text = textArea.getText();
        BraceChecker.ParseResult parseResult = braceChecker.parse(text);

        UnderlineHighlighter.UnderlineHighlightPainter painter = new UnderlineHighlighter.UnderlineHighlightPainter(Color.RED);
        Highlighter highlighter = textArea.getHighlighter();
        highlighter.removeAllHighlights();
        switch (parseResult) {
            case CLOSED_BUT_NOT_OPENED:
                int firstOffset = parseResult.getLastClosedBracket().getIndex();
                try {
                    highlighter.addHighlight(firstOffset, firstOffset + 1, painter);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                break;
            case OPENED_BUT_CLOSED_WRONG_BRACKET:
                int secondOffset = parseResult.getLastOpenedBracket().getIndex();
                firstOffset = parseResult.getLastClosedBracket().getIndex();
                try {
                    highlighter.addHighlight(firstOffset, firstOffset + 1, painter);
                    highlighter.addHighlight(secondOffset, secondOffset + 1, painter);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                break;
            case OPENED_BUT_NOT_CLOSED:
                try {
                    secondOffset = parseResult.getLastOpenedBracket().getIndex();
                    highlighter.addHighlight(secondOffset, secondOffset + 1, painter);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    private void reset() {
        file = null;
        textArea.setText("");
        this.setTitle(DEFAULT_FILENAME + " - Notepad");
    }


    private boolean openConfirmDialogCanceled(ActionEvent e) {
        int selectedOption = JOptionPane.showConfirmDialog(this, "Do you want to save changes to " + getFilename(file),
                "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
        switch (selectedOption) {
            case JOptionPane.CANCEL_OPTION:
                return true;
            case JOptionPane.YES_OPTION:
                if(!saveActionHandler(e)){
                  return true;
                }
                break;
        }
        return false;
    }

    private void handleFileChooserInOpenMode() {
        JFileChooser jOpenFileChooser = new JFileChooser();
        jOpenFileChooser.setCurrentDirectory(new File("."));
        int result = jOpenFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            loadFile(jOpenFileChooser.getSelectedFile());
        }
    }

    private static String getFilename(File file) {
        if (file == null) {
            return DEFAULT_FILENAME;
        } else {
            return file.getName();
        }
    }

    private void loadFile(File file) {
        this.file = file;
        textArea.setText(FileUtil.readFileContent(file));
        this.setTitle(file.getName() + " - Notepad");
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

    private void save() {
        if (file == null) {
            JFileChooser jSaveFileChooser = new JFileChooser();
            jSaveFileChooser.setCurrentDirectory(new File("."));
            int result = jSaveFileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File saveFile = jSaveFileChooser.getSelectedFile();
                saveAs(saveFile.getPath(), textArea.getText());
            }
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


    void exitActionHandler(ActionEvent e) {
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    void newActionHandler(ActionEvent e) {
        if (!isTextSame(file, textArea.getText())) {
            if (openConfirmDialogCanceled(e)) {
                return;
            }
        }
        reset();
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            if (!isTextSame(file, textArea.getText())) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Do you want to save changes to " + getFilename(file),
                        "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (selectedOption) {
                    case JOptionPane.CANCEL_OPTION:
                        return;
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.YES_OPTION:
                        save();
                        System.exit(0);
                        break;
                }
            }
            super.processWindowEvent(e);
        }
    }

    boolean saveAsActionHandler(ActionEvent event) {
        JFileChooser jSaveFileChooser = new JFileChooser();
        jSaveFileChooser.setCurrentDirectory(new File("."));
        int result = jSaveFileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File saveFile = jSaveFileChooser.getSelectedFile();
            saveAs(saveFile.getPath(), textArea.getText());
            return true;
        }
        return false;
    }

    void openActionHandler(ActionEvent e) {
        if (!isTextSame(file, textArea.getText())) {
            if (openConfirmDialogCanceled(e)) {
                return;
            }
        }
        handleFileChooserInOpenMode();
    }


    boolean saveActionHandler(ActionEvent event) {
        if (file == null) {
            return saveAsActionHandler(event);
        } else {
            StreamDemo.writeFile(textArea.getText(),file);
            return true;
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


    public static void main(String[] args) throws IOException {
        new Notepad();
    }
}