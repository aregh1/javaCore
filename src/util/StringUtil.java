package util;


public class StringUtil {

    /**
     * Parses the specified inputText and divides it into tokens by the specified delimiter.
     *
     * @param inputText the string to be splitted by the specified delimiter
     * @param delimiter the delimiter by which the specified inputText  will splitted.
     * @return the array of strings computed by splitting this string
     * around matches of the given regular expression.
     */
    public static String[] split(String inputText, char delimiter) {
        int count = 0;
        int j = 0;
        int k = 0;
        for (int i = 0; i < inputText.length(); i++) {
            if (inputText.charAt(i) == delimiter) {
                count++;
            }
        }
        int lastPiece = count;
        String[] dividedWords = new String[count + 1];
        for (int i = 0; i < inputText.length(); i++) {
            if (inputText.charAt(i) == delimiter) {
                String thePieces = new String();
                StringUtil.subString(inputText,j+1,i);
                thePieces = StringUtil.subString(inputText,j+1,i);
                j = i;
                dividedWords[k++] = thePieces;
            }

        }
        dividedWords[lastPiece] =StringUtil.subString(inputText,j+1,inputText.length());
        dividedWords[0] =StringUtil.subString(inputText,0,inputText.indexOf(delimiter));
        return dividedWords;
    }

    /**
     * Returns a new string that is a substring of the spcified inputText. The
     * substring begins at the specified <code>beginIndex and
     * extends to the character at index <code>endIndex - 1.
     * Thus the length of the substring is <code>endIndex-beginIndex.
     * Examples:
     * <blockquote><pre>
     * "hamburger".substring(4, 8) returns "urge"
     * "smiles".substring(1, 5) returns "mile"
     * <p>
     * @param      inputText    the string substring of witch must be returned
     * //     * @param      beginIndex   the beginning index, inclusive.
     * @param      endIndex     the ending index, exclusive.
     * @return the specified substring.
     * @exception IndexOutOfBoundsException  if the
     *             beginIndex is negative, or
     *             endIndex is larger than the length of
     *             this String object, or
     *             beginIndex is larger than
     *             endIndex.
     */
    static public String subString(String inputText, int startIndex, int endIndex) {
        char[] inputTextChar = new char[inputText.length()];
        for (int i = 0; i < inputText.length() ; i++) {
            inputTextChar[i] = inputText.charAt(i);

        }
        if (startIndex < 0) {
            throw new StringIndexOutOfBoundsException(startIndex);
        }
        if (endIndex > inputText.length()) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }
        int subLen = endIndex - startIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        return ((startIndex == 0) && (endIndex == inputText.length())) ? inputText
                : new String(inputTextChar, startIndex, subLen);
    }

    /**
     * Returns a copy of the specified str, with leading and trailing whitespace
     * omitted.
     *
     * @param str the String will be trimmed.
     * @return A copy of the string with leading and trailing white
     * space removed, or this string if it has no leading or
     * trailing white space.
     */
    public static String trim(String str) {
        int l = 0;
        char[] strChar = new char[str.length()];
        for (int i = 0; i < str.length() ; i++) {
            strChar[i] = str.charAt(i);
        }
        a:
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) != ' ' ){
                for (int j = str.length() - 1; j >= 0 ; j--) {
                    if(str.charAt(j) != ' '){
                        for (int k = i; k <= j ; k++) {
                            strChar[l++] = str.charAt(k);
                        }
                        break a;
                    }
                }
            }

        }
        String trim =new String(strChar);
        return trim;
    }

    /**
     * Parses the string argument as a signed decimal integer. The
     * characters in the string must all be decimal digits, except
     * that the first character may be an ASCII minus sign.
     *
     * @param s a String containing the int representation to be parsed
     * @return the integer value represented by the argument in decimal.
     * @throws NumberFormatException if the string does not contain a
     *                               parsable integer.
     */
    public static int parseInt(String s) {

        return 0; // TODO implement the method
    }

    public static String toLowerCase(String text) {
        return text.toLowerCase();
    }

    public static String toUpperCase(String text) {
        return text.toUpperCase();
    }

    private static String changeCase(String text, char startIndex, char endIndex) {
        return null;
    }
}