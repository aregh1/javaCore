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
        InputStream is = BraceCheckerTest.class.getClassLoader().getResourceAsStream("fileMenu_arm.properties");
        properties.load(is);
        System.out.println(properties);

        fileMenu = new JMenu(properties.getProperty(FILE.getValue()));
        settingMenu = new JMenu(properties.getProperty(SETTING.getValue()));
        JMenu languageMenu = new JMenu("Language");
        JMenuItem newMenu = new JMenuItem("New");
        JMenuItem openMenu = new JMenuItem(  "Open");
        JMenuItem saveMenu = new JMenuItem(  "Save");
        JMenuItem saveAsMenu = new JMenuItem("Save As");
        JMenuItem exitMenu = new JMenuItem(  "Exit");
        JMenuItem armenian = new JMenuItem("arm");
        JMenuItem russian = new JMenuItem("rus");
        JMenuItem france = new JMenuItem("fr");
        languageMenu.add(armenian);
        languageMenu.add(russian);
        languageMenu.add(france);
        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(saveAsMenu);
        fileMenu.add(exitMenu);
        settingMenu.add(languageMenu);
        add(fileMenu);
        add(settingMenu);

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
        FILE("file"),
        NEW("new"),
        OPEN("open"),
        SAVE("save"),
        SAVE_AS("saveAs"),
        EXIT("exit");


        public String getValue() {
            return value;
        }

        private String value;

        NotepadMenuItem(String value) {
            this.value = value;
        }

    }


}
