package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Areg on 9/2/2017.
 */
public class FileUtil {
    public static String readFileContent(File file) {
        FileInputStream fileInputStream = null;
        byte[] buff;
        String fileContent = null;
        try {
            fileInputStream = new FileInputStream(file);
            buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            fileContent = new String(buff);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            close(fileInputStream);
        }
        return fileContent;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String open(String openPath) {
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


    public static List<File> search(File dirToSearchIn, String fileNameMask) {
        if (dirToSearchIn == null) {
//            throw;
        }
        if (fileNameMask == null) {
//            throw
        }
        if (!dirToSearchIn.isDirectory()) {
//            throw
        }
        List<File> resultList = new ArrayList<>();
        search0(resultList, dirToSearchIn, fileNameMask);
        return resultList;
    }

    private static void search0(List<File> resultList, File dirTosearchIn, String fileNameMask) {
        File[] files = dirTosearchIn.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                search0(resultList, files[i], fileNameMask);
            } else {
                if (files[i].getName().contains(fileNameMask)){
                    resultList.add(files[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File(".");
        List<File> list = search(file,"ku");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.remove(i));
        }
    }
}
