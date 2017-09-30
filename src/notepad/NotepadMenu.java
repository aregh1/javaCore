package notepad;

import bracechecker.BraceCheckerTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static notepad.NotepadMenu.NotepadMenuItem.*;

/**
 * Created by Areg on 9/23/2017.
 */
public class NotepadMenu extends JMenuBar {
    private JMenu fileMenu;
    private Notepad notepad;
    private JMenu settingMenu;


    public NotepadMenu(Notepad notepad) throws IOException {
        this.notepad = notepad;

        Properties properties = new Properties();
        InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream("fileMenu.properties");
        properties.load(is);

        fileMenu = new JMenu(properties.getProperty(FILE.getValue()));
        settingMenu = new JMenu(properties.getProperty(SETTING.getValue()));
        JMenu languageMenu = new JMenu(properties.getProperty(LANGUAGE.getValue()));
        JMenuItem newMenu = new JMenuItem(properties.getProperty(NEW.getValue()));
        JMenuItem openMenu = new JMenuItem(properties.getProperty(OPEN.getValue()));
        JMenuItem saveMenu = new JMenuItem(properties.getProperty(SAVE.getValue()));
        JMenuItem saveAsMenu = new JMenuItem(properties.getProperty(SAVE_AS.getValue()));
        JMenuItem exitMenu = new JMenuItem(properties.getProperty(EXIT.getValue()));
        JMenuItem armenian = new JMenuItem(properties.getProperty(ARMENIAN.getValue()));
        JMenuItem russian = new JMenuItem(properties.getProperty(RUSSIAN.getValue()));
        JMenuItem french = new JMenuItem(properties.getProperty(FRENCH.getValue()));
        JMenuItem english = new JMenuItem(properties.getProperty(ENGLISH.getValue()));
        add(fileMenu);
        add(settingMenu);
        settingMenu.add(languageMenu);
        languageMenu.add(armenian);
        languageMenu.add(russian);
        languageMenu.add(french);
        languageMenu.add(english);
        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(saveAsMenu);
        fileMenu.add(exitMenu);
        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties properties = new Properties();
                InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream("fileMenu.properties");
                try {
                    properties.load(is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fileMenu.setText(properties.getProperty(FILE.getValue()));
                settingMenu.setText(properties.getProperty(SETTING.getValue()));
                languageMenu.setText(properties.getProperty(LANGUAGE.getValue()));
                newMenu.setText(properties.getProperty(NEW.getValue()));
                openMenu.setText(properties.getProperty(OPEN.getValue()));
                saveMenu.setText(properties.getProperty(SAVE.getValue()));
                saveAsMenu.setText(properties.getProperty(SAVE_AS.getValue()));
                exitMenu.setText(properties.getProperty(EXIT.getValue()));
                armenian.setText(properties.getProperty(ARMENIAN.getValue()));
                russian.setText(properties.getProperty(RUSSIAN.getValue()));
                french.setText(properties.getProperty(FRENCH.getValue()));
                english.setText(properties.getProperty(ENGLISH.getValue()));
            }
        });
        armenian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties properties = new Properties();
                InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream("fileMenu_arm.properties");
                try {
                    properties.load(is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fileMenu.setText(properties.getProperty(FILE.getValue()));
                settingMenu.setText(properties.getProperty(SETTING.getValue()));
                languageMenu.setText(properties.getProperty(LANGUAGE.getValue()));
                newMenu.setText(properties.getProperty(NEW.getValue()));
                openMenu.setText(properties.getProperty(OPEN.getValue()));
                saveMenu.setText(properties.getProperty(SAVE.getValue()));
                saveAsMenu.setText(properties.getProperty(SAVE_AS.getValue()));
                exitMenu.setText(properties.getProperty(EXIT.getValue()));
                armenian.setText(properties.getProperty(ARMENIAN.getValue()));
                russian.setText(properties.getProperty(RUSSIAN.getValue()));
                french.setText(properties.getProperty(FRENCH.getValue()));
                english.setText(properties.getProperty(ENGLISH.getValue()));
            }
        });
        russian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties properties = new Properties();
                InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream("fileMenu_ru.properties");
                try {
                    properties.load(is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fileMenu.setText(properties.getProperty(FILE.getValue()));
                settingMenu.setText(properties.getProperty(SETTING.getValue()));
                languageMenu.setText(properties.getProperty(LANGUAGE.getValue()));
                newMenu.setText(properties.getProperty(NEW.getValue()));
                openMenu.setText(properties.getProperty(OPEN.getValue()));
                saveMenu.setText(properties.getProperty(SAVE.getValue()));
                saveAsMenu.setText(properties.getProperty(SAVE_AS.getValue()));
                exitMenu.setText(properties.getProperty(EXIT.getValue()));
                armenian.setText(properties.getProperty(ARMENIAN.getValue()));
                russian.setText(properties.getProperty(RUSSIAN.getValue()));
                french.setText(properties.getProperty(FRENCH.getValue()));
                english.setText(properties.getProperty(ENGLISH.getValue()));
            }
        });
        french.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties properties = new Properties();
                InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream("fileMenu_fr.properties");
                try {
                    properties.load(is);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fileMenu.setText(properties.getProperty(FILE.getValue()));
                settingMenu.setText(properties.getProperty(SETTING.getValue()));
                languageMenu.setText(properties.getProperty(LANGUAGE.getValue()));
                newMenu.setText(properties.getProperty(NEW.getValue()));
                openMenu.setText(properties.getProperty(OPEN.getValue()));
                saveMenu.setText(properties.getProperty(SAVE.getValue()));
                saveAsMenu.setText(properties.getProperty(SAVE_AS.getValue()));
                exitMenu.setText(properties.getProperty(EXIT.getValue()));
                armenian.setText(properties.getProperty(ARMENIAN.getValue()));
                russian.setText(properties.getProperty(RUSSIAN.getValue()));
                french.setText(properties.getProperty(FRENCH.getValue()));
                english.setText(properties.getProperty(ENGLISH.getValue()));
            }
        });


        newMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.newActionHandler(e);
            }
        });
        openMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.openActionHandler(e);
            }
        });
        saveMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.saveActionHandler(e);
            }
        });
        saveAsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.saveAsActionHandler(e);
            }
        });
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.exitActionHandler(e);
            }
        });
    }

    public enum NotepadMenuItem {
        SETTING("setting"),
        LANGUAGE("language"),
        ARMENIAN("armenian"),
        RUSSIAN("russian"),
        FRENCH("french"),
        FILE("file"),
        NEW("new"),
        OPEN("open"),
        SAVE("save"),
        SAVE_AS("saveAs"),
        EXIT("exit"),
        ENGLISH("english");

        public String getValue() {
            return value;
        }

        private String value;

        NotepadMenuItem(String value) {
            this.value = value;
        }

    }
}
