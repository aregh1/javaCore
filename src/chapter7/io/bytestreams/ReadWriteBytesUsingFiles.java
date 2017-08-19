package chapter7.io.bytestreams;

import java.io.*;

public class ReadWriteBytesUsingFiles {
	public static void main(String[] args) throws IOException {
		try (
			FileInputStream in = new FileInputStream("Sample.pdf");
			FileOutputStream out = new FileOutputStream("Sample2.pdf");
		) {
			int data;
			while ((data = in.read()) != -1) {
				out.write(data);
			}
		}
	}
}