package bracechecker.ui;

import bracechecker.BraceChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Areg on 3/26/2017.
 */
public class ParserFrame extends JFrame {
    private JTextField messageField = new JTextField();
    private JTextArea textArea = new JTextArea();
    private BraceChecker braceChecker;

    public ParserFrame() throws HeadlessException {
        JPanel controlPanel = new JPanel();
        JButton parseButton = new JButton("Parse");
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
        resultPanel.add(messageField);

        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        setLocation(100, 100);
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void parseActionHandler(){
        String text = textArea.getText();
        if(braceChecker == null) {
            braceChecker = new BraceChecker();
        }
        braceChecker.parse(text);
        messageField.setText(braceChecker.getResultMessage());
    }

    public static void main(String[] args) {
        new ParserFrame();
    }
}
