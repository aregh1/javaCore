package notepad;

import java.awt.*;
import java.io.*;

/**
 * Created by Areg on 8/18/2017.
 */
public class NotepadPanel {
    String open(String openPath) {
        FileInputStream in = null;
        BufferedInputStream bfin = null;
        byte[] buf = null;
        try {
            in = new FileInputStream(openPath);
            bfin = new BufferedInputStream(in);
            buf = new byte[in.available()];
            in.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(bfin);
        }
        String text = new String(buf);
        return text;
    }

    void save(String savePath, String filename, String content) {

    }

    void saveAs(String saveAsPath, String content) {
        FileOutputStream out = null;
        BufferedOutputStream bfOut = null;
        File file = new File(saveAsPath);
        try {
            out = new FileOutputStream(file);
            bfOut = new BufferedOutputStream(out);
            bfOut.write(content.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(bfOut);
        }
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
