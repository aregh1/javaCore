package bracechecker;

import bracechecker.util.Stack;
import bracechecker.util.StackImpl;

/**
 * Created by Areg on 3/5/2017.
 */
public class BraceChecker {
    private static final String DEFAULT_MESSAGE = "No Errors";
    private Stack<BracketItem> stack;
    private String resultMessage;

    /**
     *
     */
    public BraceChecker() {
        stack = new StackImpl<>();
        resultMessage = DEFAULT_MESSAGE;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void parse(String text) {
        reset();
        char ch = 0;
        BracketItem currentBracketItem = null;
        BracketItem stackLastElement = null;
        int lineNumber = 1;
        int numberInLine = 0;
        int i = 0;
        lab:
        for (; i < text.length(); i++) {
            ch = text.charAt(i);
            numberInLine++;
            switch (ch) {
                case '\n':
                case '\r':
                    lineNumber++;
                    numberInLine = 0;
                    break;
                case '{':
                case '[':
                case '(':
                    stack.push(new BracketItem(ch, i, lineNumber, numberInLine));
                    break;
                case '}':
                    stackLastElement = stack.pop();
                    if (stackLastElement == null || stackLastElement.getValue() != '{') {
                        currentBracketItem = new BracketItem(ch, i, lineNumber, numberInLine);
                        break lab;
                    }
                    break;
                case ']':
                    stackLastElement = stack.pop();
                    if (stackLastElement == null || stackLastElement.getValue() != '[') {
                        currentBracketItem = new BracketItem(ch, i, lineNumber, numberInLine);
                        break lab;
                    }
                    break;
                case ')':
                    stackLastElement = stack.pop();
                    if (stackLastElement == null || stackLastElement.getValue() != '(') {
                        currentBracketItem = new BracketItem(ch, i, lineNumber, numberInLine);
                        break lab;
                    }
                    break;
            }
        }
        if (i < text.length()) {
            if (stackLastElement == null) {
                resultMessage = "Error: Closed " + currentBracketItem + " but not opened";
            } else {
                resultMessage = "Error: Closed " + currentBracketItem + " but opened " + stackLastElement + "'.";
            }
        } else {
            stackLastElement = stack.pop();
            if (stackLastElement != null) {
                resultMessage = "Error: Opened '" + stackLastElement + "' but not closed";
            }
        }
    }

    private void reset() {
        stack.reset();
        resultMessage = DEFAULT_MESSAGE;
    }

    static class BracketItem {
        private char value = 0;
        private int index = 0;
        private int lineNumber = 0;
        private int numberInLine = 0;

        public void setValue(char value) {
            this.value = value;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        public void setNumberInLine(int numberInLine) {
            this.numberInLine = numberInLine;
        }

        public char getValue() {

            return value;
        }

        public int getIndex() {
            return index;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public int getNumberInLine() {
            return numberInLine;
        }

        public BracketItem(char value, int index, int lineNumber, int numberInLine) {
            this.value = value;
            this.index = index;
            this.lineNumber = lineNumber;
            this.numberInLine = numberInLine;
        }

        @Override
        public String toString() {
            return " '" + value +
                    "' [" + lineNumber +
                    " : " + numberInLine + ']';
        }
    }
}
