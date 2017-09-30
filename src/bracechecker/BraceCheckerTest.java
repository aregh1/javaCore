package bracechecker;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import notepad.NotepadMenuBar;

/**
 * Created by Areg on 3/6/2017.
 */
public class BraceCheckerTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream is = BraceCheckerTest.class.getClassLoader().getResourceAsStream("fileMenu_arm.properties");
        properties.load(is);
        System.out.println(properties);

        for (NotepadMenuBar.FileMenuItem value: NotepadMenuBar.FileMenuItem.values()) {
            System.out.println(properties.getProperty(value.getValue() ));
        }


//        BraceChecker braceChecker = new BraceChecker();
//        BraceChecker.ParseResult parseResult = braceChecker.parse("{");
//        switch (parseResult){
//            case NO_ERROR:
//                //todo something
//                break;
//            case CLOSED_BUT_NOT_OPENED:
//                //todo something
//                break;
//            case OPENED_BUT_CLOSED_WRONG_BRACKET:
//                //todo something
//                break;
//            case OPENED_BUT_NOT_CLOSED:
//                //todo something
//                break;
//        }
//        System.out.println(parseResult);
    }
}
