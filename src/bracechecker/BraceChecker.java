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

    public BraceChecker() {
        stack = new StackImpl<>();
        resultMessage = DEFAULT_MESSAGE;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public ParseResult parse(String text) {
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

        ParseResult parseResult = ParseResult.NO_ERROR;
        if (i < text.length()) {
            if (stackLastElement == null) {
                parseResult = ParseResult.CLOSED_BUT_NOT_OPENED;
                parseResult.setLastClosedBracket(currentBracketItem);
                resultMessage = "Error: Closed " + currentBracketItem + " but not opened";
            } else {
                parseResult = ParseResult.OPENED_BUT_CLOSED_WRONG_BRACKET;
                parseResult.setLastClosedBracket(currentBracketItem);
                parseResult.setLastOpenedBracket(stackLastElement);
                resultMessage = "Error: Closed " + currentBracketItem + " but opened " + stackLastElement + "'.";
            }
            parseResult.setResultMessage(resultMessage);
        } else {
            stackLastElement = stack.pop();
            if (stackLastElement != null) {
                parseResult = ParseResult.OPENED_BUT_NOT_CLOSED;
                parseResult.setLastOpenedBracket(stackLastElement);
                resultMessage = "Error: Opened '" + stackLastElement + "' but not closed";
                parseResult.setResultMessage(resultMessage);
            }
        }

        return parseResult;
    }

    private void reset() {
        stack.reset();
        resultMessage = DEFAULT_MESSAGE;
    }

    public static class BracketItem {
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

    public enum ParseResult{
        NO_ERROR(null, null, null),
        OPENED_BUT_NOT_CLOSED(null, null, null),
        OPENED_BUT_CLOSED_WRONG_BRACKET(null, null, null),
        CLOSED_BUT_NOT_OPENED(null, null, "No Error"),;

        ParseResult(BracketItem lastOpenedBracket, BracketItem lastClosedBracket, String resultMessage) {
            this.lastOpenedBracket = lastOpenedBracket;
            this.lastClosedBracket = lastClosedBracket;
            this.resultMessage = resultMessage;
        }

        public void setLastClosedBracket(BracketItem lastClosedBracket) {
            this.lastClosedBracket = lastClosedBracket;
        }

        public void setLastOpenedBracket(BracketItem lastOpenedBracket) {
            this.lastOpenedBracket = lastOpenedBracket;
        }

        public void setResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }

        public BracketItem getLastOpenedBracket() {
            return lastOpenedBracket;
        }

        public BracketItem getLastClosedBracket() {
            return lastClosedBracket;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        private BracketItem lastOpenedBracket;
        private BracketItem lastClosedBracket;
        private String resultMessage;
    }
}
