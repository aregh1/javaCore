package notepad.util;
// A simple class that searches for a word in
// a document and highlights occurrences of that word

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class WordSearcher {

    protected JTextComponent comp;
    protected Highlighter.HighlightPainter painter;

    public WordSearcher(JTextComponent comp) {
        this.comp = comp;
        this.painter = new UnderlineHighlighter.UnderlineHighlightPainter(Color.red);
    }

    // Search for a word and return the offset of the
    // first occurrence. Highlights are added for all
    // occurrences found.
    public int search(String word) {
        int firstOffset = -1;
        Highlighter highlighter = comp.getHighlighter();

        // Remove any existing highlights for last word
        Highlighter.Highlight[] highlights = highlighter.getHighlights();
        for (int i = 0; i < highlights.length; i++) {
            Highlighter.Highlight highlight = highlights[i];

            if (highlight.getPainter() instanceof UnderlineHighlighter.UnderlineHighlightPainter) {
                highlighter.removeHighlight(highlight);
            }
        }

        if (word == null || word.equals("")) {
            return -1;
        }

        // Look for the word we are given - insensitive search
        String content = null;
        try {
            Document d = comp.getDocument();
            content = d.getText(0, d.getLength()).toLowerCase();
        } catch (BadLocationException e) {
            e.printStackTrace();
            return -1;
        }

        word = word.toLowerCase();
        int lastIndex = 0;
        int wordSize = word.length();

        while ((lastIndex = content.indexOf(word, lastIndex)) != -1) {
            int endIndex = lastIndex + wordSize;
            try {
                highlighter.addHighlight(lastIndex, endIndex, painter);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            if (firstOffset == -1) {
                firstOffset = lastIndex;
            }
            lastIndex = endIndex;
        }
        return firstOffset;
    }
}