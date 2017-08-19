package chapter7.io.prmitives;

import java.io.*;

public class ReadWritePrimitiveData1 {
	public static void main(String... args) throws IOException {
		try (
			FileOutputStream fos = new FileOutputStream(
				new File("myData.data"));
			DataOutputStream dos = new DataOutputStream(fos);
			FileInputStream fis = new FileInputStream("myData.data");
			DataInputStream dis = new DataInputStream(fis);) {
			dos.writeBoolean(true);
			dos.writeChar('A');
			dos.writeInt(99);
			System.out.println(dis.readInt());
		}
	}
}