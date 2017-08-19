package chapter7.io.bytestreams;

import java.io.*;

public class ReadWriteBytesUsingFiles2 {
	public static void main(String[] args) throws IOException {
		try (
			FileInputStream in = new FileInputStream(
				new File("Sample.pdf"));
			FileOutputStream out = new FileOutputStream("Sample2.pdf");
		) {
			int data;
			byte[] byteArr = new byte[1024];
			while ((data = in.read(byteArr)) != -1) {
				out.write(byteArr, 0, data);
			}

		}

	}
}