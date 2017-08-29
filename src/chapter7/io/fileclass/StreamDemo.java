package chapter7.io.fileclass;

import java.io.*;

/**
 * Created by karenvardanyan on 8/5/17.
 */
public class StreamDemo {

	public static void main(String[] args) {
		File file = new File("file.txt");
		byte[] buff = readFile(file);
		String fileContent = new String (buff);
		System.out.println(fileContent);

		writeFile(fileContent, new File("file_copy.txt"));


	}

	static byte[] readFile (File file) {
		InputStream in = null;
		byte [] buff = null;
		try {
			in = new FileInputStream(file);
			buff = new byte[in.available()];
			in.read(buff);
			return buff;

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(in);
		}

	}

	static void writeFile(String content, File file) {
		OutputStream out = null;

		try {
			out = new FileOutputStream(file);

			out.write(content.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(out);
		}
	}

	static void close (Closeable closeable){
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
