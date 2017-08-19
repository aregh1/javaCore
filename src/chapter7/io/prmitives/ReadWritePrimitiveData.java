package chapter7.io.prmitives;

import java.io.*;

public class ReadWritePrimitiveData {
	public static void main(String... args) throws IOException {
		try (
			FileOutputStream fos = new FileOutputStream(new File("myData.data"));
			DataOutputStream dos = new DataOutputStream(fos);
			FileInputStream fis = new FileInputStream("myData.data");
			DataInputStream dis = new DataInputStream(fis);
		) {
			dos.writeChars("OS");
			dos.writeInt(999);
			dos.writeDouble(45.8);
			dos.writeBoolean(true);
			dos.writeUTF("Will score 100%");

			System.out.println(dis.readChar());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
			System.out.println(dis.readBoolean()); //﻿ If uncommented, this line	throws EOFException at runtime
		}
	}
}