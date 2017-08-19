package chapter7.io.fileclass;

import java.io.*;

public class CreateFileAndDirs {
	public static void main(String... args) throws IOException {
		File file = new File(".");
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {

				return true;
			}
		});
		print(files);
		File dirs = new File("./usr", "00/11");
		System.out.println(dirs.mkdirs());
		file = new File(dirs, "MyText.txt");
		if (!file.exists())
			System.out.println(file.createNewFile());
	}


	static void print(File[] files){
		for (File file: files) {
			System.out.println(file);
		}
	}
}