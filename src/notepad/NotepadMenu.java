package notepad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Areg on 9/23/2017.
 */
public class NotepadMenu extends JMenuBar {
    private JMenu fileMenu;
    private Notepad notepad;



    public NotepadMenu(Notepad notepad) {
        this.notepad = notepad;

        fileMenu = new JMenu("File");
        JMenuItem newMenu = new JMenuItem();
        JMenuItem openMenu = new JMenuItem(  "Open");
        JMenuItem saveMenu = new JMenuItem(  "Save");
        JMenuItem saveAsMenu = new JMenuItem("Save As");
        JMenuItem exitMenu = new JMenuItem(  "Exit");
        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(saveAsMenu);
        fileMenu.add(exitMenu);
        add(fileMenu);


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
