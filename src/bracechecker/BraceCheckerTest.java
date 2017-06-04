package bracechecker;

/**
 * Created by Areg on 3/6/2017.
 */
public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker();
        braceChecker.parse("");
        System.out.println(braceChecker.getResultMessage());
    }
}
