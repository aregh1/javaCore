package chapter7.io.fileclass;

import java.io.*;

/**
 * Created by karenvardanyan on 8/5/17.
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("kuku.txt");
//		file.createNewFile();

		file = new File("./");
		System.out.println("file.isDirectory(): " + file.isDirectory());
		File[] children = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".pdf");
			}
		});
		for (File child : children) {
			System.out.println(child);
		}

	}

}
