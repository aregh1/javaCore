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
        createFileMenu();
        createLanguageMenu();
//        fileMenu = new JMenu();
//        JMenuItem newMenuItem = new JMenuItem();
//        JMenuItem openMenuItem = new JMenuItem();
//        JMenuItem saveMenuItem = new JMenuItem();
//        JMenuItem saveAsMenuItem = new JMenuItem();
//        JMenuItem exitMenuItem = new JMenuItem();


        //Language subMenu
//        languageMenu = new JMenu();
//        JMenuItem armenianMenuItem = new JMenuItem();
//        JMenuItem russianMenuItem = new JMenuItem();
//        JMenuItem frenchMenuItem = new JMenuItem();
//        JMenuItem englishMenuItem = new JMenuItem();
//        languageMenu.add(armenianMenuItem);
//        languageMenu.add(russianMenuItem);
//        languageMenu.add(frenchMenuItem);
//        languageMenu.add(englishMenuItem);
        settingMenu = new JMenu();
        settingMenu.add(languageMenu);
//        fileMenu.add(newMenuItem);
//        fileMenu.add(openMenuItem);
//        fileMenu.add(saveMenuItem);
//        fileMenu.add(saveAsMenuItem);
//        fileMenu.add(exitMenuItem);
//        englishMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentLanguage = LanguageMenuItem.ENGLISH;
//                loadMenuBarTexts();
//            }
//        });
//        armenianMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentLanguage = LanguageMenuItem.ARMENIAN;
//                loadMenuBarTexts();
//            }
//        });
//        russianMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentLanguage = LanguageMenuItem.RUSSIAN;
//                loadMenuBarTexts();
//            }
//        });
//        frenchMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentLanguage = LanguageMenuItem.FRENCH;
//                loadMenuBarTexts();
//            }
//        });
//
//        fileMenu.getItem(0).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                notepad.newActionHandler(e);
//            }
//        });
//        fileMenu.getItem(1).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                notepad.openActionHandler(e);
//            }
//        });
//        fileMenu.getItem(2).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                notepad.saveActionHandler(e);
//            }
//        });
//        fileMenu.getItem(3).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                notepad.saveAsActionHandler(e);
//            }
//        });
//        fileMenu.getItem(4).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                notepad.exitActionHandler(e);
//            }
//        });
        currentLanguage = DEFAULT_LANGUAGE;
        loadMenuBarTexts();

        add(fileMenu);
        add(settingMenu);
    }

    private void createFileMenu(){
        fileMenu = new JMenu();
        JMenuItem newMenuItem = new JMenuItem();
        JMenuItem openMenuItem = new JMenuItem();
        JMenuItem saveMenuItem = new JMenuItem();
        JMenuItem saveAsMenuItem = new JMenuItem();
        JMenuItem exitMenuItem = new JMenuItem();
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(exitMenuItem);
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.newActionHandler(e);
            }
        });
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.openActionHandler(e);
            }
        });
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.saveActionHandler(e);
            }
        });
        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.saveAsActionHandler(e);
            }
        });
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad.exitActionHandler(e);
            }
        });


    }

    private void createLanguageMenu(){
        languageMenu = new JMenu();
        JMenuItem armenianMenuItem = new JMenuItem();
        JMenuItem russianMenuItem = new JMenuItem();
        JMenuItem frenchMenuItem = new JMenuItem();
        JMenuItem englishMenuItem = new JMenuItem();
        languageMenu.add(armenianMenuItem);
        languageMenu.add(russianMenuItem);
        languageMenu.add(frenchMenuItem);
        languageMenu.add(englishMenuItem);
        englishMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.ENGLISH;
                loadMenuBarTexts();
            }
        });
        armenianMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.ARMENIAN;
                loadMenuBarTexts();
            }
        });
        russianMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.RUSSIAN;
                loadMenuBarTexts();
            }
        });
        frenchMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLanguage = LanguageMenuItem.FRENCH;
                loadMenuBarTexts();
            }
        });
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
        loadMenuTexts(languageMenu , LanguageMenuItem.getNames(), properties);
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
