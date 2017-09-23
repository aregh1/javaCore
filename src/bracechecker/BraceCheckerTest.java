package bracechecker;

/**
 * Created by Areg on 3/6/2017.
 */
public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker();
        BraceChecker.ParseResult parseResult = braceChecker.parse("{");
        switch (parseResult){
            case NO_ERROR:
                //todo something
                break;
            case CLOSED_BUT_NOT_OPENED:
                //todo something
                break;
            case OPENED_BUT_CLOSED_WRONG_BRACKET:
                //todo something
                break;
            case OPENED_BUT_NOT_CLOSED:
                //todo something
                break;
        }
        System.out.println(parseResult);
    }
}
