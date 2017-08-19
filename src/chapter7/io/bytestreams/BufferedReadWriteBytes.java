package chapter7.io.bytestreams;

import java.io.*;

public class BufferedReadWriteBytes {
	public static void main(String[] args) throws IOException {
		try (
			FileInputStream in = new FileInputStream("jls7.pdf");
			FileOutputStream out = new FileOutputStream("jls7-copy.pdf");
			BufferedInputStream bis = new BufferedInputStream(in);
			BufferedOutputStream bos = new BufferedOutputStream(out);
		) {
			long start = System.currentTimeMillis();
			int data;
			while ((data = bis.read()) != -1) {
				bos.write(data);
			}
			System.out.println("MilliSeconds elapsed : " + (System.currentTimeMillis() - start));
		} catch (Exception e){
			//
		}
	}
}