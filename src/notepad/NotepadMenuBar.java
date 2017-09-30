package notepad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static notepad.NotepadMenuBar.FileMenuItem.*;

/**
 * Created by Areg on 9/23/2017.
 */
public class NotepadMenuBar extends JMenuBar {
    private static final LanguageMenuItem DEFAULT_LANGUAGE = LanguageMenuItem.ENGLISH;

    private Notepad notepad;
    private JMenu fileMenu;
    private JMenu settingMenu;
    private JMenu languageMenu;
    private LanguageMenuItem currentLanguage;


    public NotepadMenuBar(Notepad notepad) throws IOException {
        this.notepad = notepad;


        fileMenu = new JMenu();
        JMenuItem newMenu = new JMenuItem();
        JMenuItem openMenu = new JMenuItem();
        JMenuItem saveMenu = new JMenuItem();
        JMenuItem saveAsMenu = new JMenuItem();
        JMenuItem exitMenu = new JMenuItem();


        //Language subMenu
        languageMenu = new JMenu();
        JMenuItem armenian = new JMenuItem();
        JMenuItem russian = new JMenuItem();
        JMenuItem french = new JMenuItem();
        JMenuItem english = new JMenuItem();
        languageMenu.add(armenian);
        languageMenu.add(russian);
        languageMenu.add(french);
        languageMenu.add(english);

        settingMenu = new JMenu();
        settingMenu.add(languageMenu);

        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(saveAsMenu);
        fileMenu.add(exitMenu);
        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.ENGLISH;
                loadMenuBarTexts();
            }
        });
        armenian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.ARMENIAN;
                loadMenuBarTexts();
            }
        });
        russian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.RUSSIAN;
                loadMenuBarTexts();
            }
        });
        french.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.FRENCH;
                loadMenuBarTexts();
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

        currentLanguage = DEFAULT_LANGUAGE;
        loadMenuBarTexts();

        add(fileMenu);
        add(settingMenu);
    }

    private void loadMenuBarTexts () {
        Properties properties = new Properties();
        InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream(currentLanguage.getPropertiesFileName());
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace(); // TODO accurate the handling later
        }

        fileMenu.setText(properties.getProperty(NotepadMenu.FILE.getName()));
        settingMenu.setText(properties.getProperty(NotepadMenu.SETTINGS.getName()));
        loadMenuTexts(fileMenu, FileMenuItem.getNames(), properties);
        loadMenuTexts(settingMenu, SettingsMenuItem.getNames(), properties);
        loadMenuTexts( languageMenu , SettingsMenuItem.getNames(), properties);
    }

    private void loadMenuTexts(JMenu menu, String[] keys, Properties properties) {
        int i = 0;
        for (String itemTextKey : keys) {
            menu.getItem(i++).setText(properties.getProperty(itemTextKey));
        }
    }

    public enum FileMenuItem {
        NEW("new"),
        OPEN("open"),
        SAVE("save"),
        SAVE_AS("saveAs"),
        EXIT("exit");

        FileMenuItem(String value) {
            this.name = value;
        }

        public static String[] getNames() {
            FileMenuItem[] values = values();
            String[] result = new String[values.length];
            int i = 0;
            for (FileMenuItem fileMenuItem : values) {
                result[i++] = fileMenuItem.getName();
            }
            return result;
        }

        public String getName() {
            return name;
        }

        private String name;
    }

    public enum NotepadMenu {
        FILE("file"),
        SETTINGS("settings");

        public String getName() {
            return name;
        }

        private String name;

        public static String[] getNames() {
            NotepadMenu[] values = values();
            String[] result = new String[values.length];
            int i = 0;
            for (NotepadMenu notepadMenuItems : values) {
                result[i++] = notepadMenuItems.getName();
            }
            return result;
        }

        NotepadMenu(String name) {
            this.name = name;
        }

    }

    public enum SettingsMenuItem {
        LANGUAGE("language");

        public String getName() {
            return name;
        }

        public static String[] getNames() {
            SettingsMenuItem[] values = values();
            String[] result = new String[values.length];
            int i = 0;
            for (SettingsMenuItem settingsMenuItem : values) {
                result[i++] = settingsMenuItem.getName();
            }
            return result;
        }

        SettingsMenuItem(String name) {
            this.name = name;
        }


        private String name;
    }

    public enum LanguageMenuItem {
        ARMENIAN("armenian", "fileMenu_arm.properties"),
        RUSSIAN("russian", "fileMenu_ru.properties"),
        FRENCH("french", "fileMenu_fr.properties"),
        ENGLISH("english", "fileMenu.properties");

        LanguageMenuItem(String name, String propertiesFileName) {
            this.name = name;
            this.propertiesFileName = propertiesFileName;
        }

        public String getName() {
            return name;
        }

        public String getPropertiesFileName() {
            return propertiesFileName;
        }

        public static String[] getNames() {
            LanguageMenuItem[] values = values();
            String[] result = new String[values.length];
            int i = 0;
            for (LanguageMenuItem languageMenuItem : values) {
                result[i++] = languageMenuItem.getName();
            }
            return result;
        }

        private String propertiesFileName;
        private String name;
    }
}
