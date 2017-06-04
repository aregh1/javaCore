package draft;

import bracechecker.BraceChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Areg on 4/2/2017.
 */
public class ParserFrameSecond extends JFrame {
    private JTextField messageFeild = new JTextField();
    JTextArea textArea = new JTextArea();

    ParserFrameSecond() {
        JPanel controlPanel = new JPanel();
        JButton parseButton = new JButton();
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseActionHandler();
            }
        });
        controlPanel.add(parseButton);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(textArea);
        JPanel resultPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(1, 1);
        resultPanel.setLayout(gridLayout);
        resultPanel.add(messageFeild);
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
        setLocation(-7, 0);
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void parseActionHandler() {
        String text = new String();
        BraceChecker braceChecker = new BraceChecker();
        braceChecker.parse(text);
        messageFeild.setText(braceChecker.getResultMessage());

    }

    public static void main(String[] args) {
        new ParserFrameSecond();
    }
}
