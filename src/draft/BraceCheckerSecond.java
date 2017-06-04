package draft;

/**
 * Created by Areg on 3/21/2017.
 */
public class BraceCheckerSecond {
    private StackSecond stackSecond;
    private String resultMessage;

    BraceCheckerSecond() {
        stackSecond = new StackSecond();
        resultMessage = "No Error";
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void parse(String text) {
        char ch = 0;
        int i = 0;
        char stacklastelement = 0;
        lab:
        for (; i < text.length(); i++) {
            ch = text.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stackSecond.push(ch);
                    break;
                case '}':
                    stacklastelement = (char) stackSecond.pop();
                    if (stacklastelement != '{') {
                        break lab;
                    }
                    break;
                case ']':
                    stacklastelement = (char) stackSecond.pop();
                    if (stacklastelement != '[') {
                        break lab;
                    }
                    break;
                case ')':
                    stacklastelement = (char) stackSecond.pop();
                    if (stacklastelement != '(') {
                        break lab;
                    }
                    break;


            }
            if (i < text.length()) {
                if (stacklastelement == 0) {
                    resultMessage = "Error: Closed '" + ch + "' but not opened";
                } else {
                    resultMessage = "Error: Closed '" + ch + "' but opened'" + stacklastelement + "'";
                }
            } else {
                stacklastelement = (char) stackSecond.pop();
                if (stacklastelement != 0) {
                    resultMessage = "Error: Opened '" + stacklastelement + "' but not closed";
                }

            }
        }


    }
}
