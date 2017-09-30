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
    private JMenu fileMenu;
    private Notepad notepad;
    private JMenu settingMenu;
    private String currentLanguage;


    public NotepadMenuBar(Notepad notepad) throws IOException {
        this.notepad = notepad;

        Properties properties = new Properties();
        InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream("fileMenu.properties");
        properties.load(is);

        loadMenuTexts(this, NotepadMenu.);
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

    private void loadSettingsMenuText(String language) {
        Properties properties = new Properties();
        InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream(language);
        try {
            properties.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        loadMenuTexts(settingMenu, FileMenuItem.getNames(), properties);
    }

    private void loadLanguageMenuText(String language) {
        Properties properties = new Properties();
        InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream(language);
        try {
            properties.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        loadMenuTexts((JMenu)settingMenu.getMenuComponent(0), FileMenuItem.getNames(), properties);
    }

    private void loadFileMenuText(String language) {
        Properties properties = new Properties();
        InputStream is = NotepadMenu.class.getClassLoader().getResourceAsStream(language);
        try {
            properties.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        loadMenuTexts(fileMenu, FileMenuItem.getNames(), properties);
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
        ARMENIAN("armenian"),
        RUSSIAN("russian"),
        FRENCH("french"),
        ENGLISH("english");

        public String getName() {
            return name;
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


        LanguageMenuItem(String name) {
            this.name = name;
        }

        private String name;
    }
}
