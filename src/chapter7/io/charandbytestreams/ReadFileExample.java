package chapter7.io.charandbytestreams;

import java.io.*;

public class ReadFileExample {

	private static final String FILE_NAME = "file.txt";

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}