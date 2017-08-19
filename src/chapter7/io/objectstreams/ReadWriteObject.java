package chapter7.io.objectstreams;

import java.io.*;



public class ReadWriteObject {
	public static void main(String args[]) throws Exception {
		try (
			FileOutputStream out = new FileOutputStream("object.data");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			FileInputStream in = new FileInputStream("object.data");
			ObjectInputStream ois = new ObjectInputStream(in);
		) {
			Car c = new Car();
			oos.writeObject(c);
			oos.flush();
			Car c2 = (Car) ois.readObject();
			System.out.println(c2);
		}
	}
}

class WriteObject{
	public static void main(String args[]) throws IOException{
		try (
			FileOutputStream out = new FileOutputStream("object.data");
			ObjectOutputStream oos = new ObjectOutputStream(out);
		) {
			Car c = new Car();
			oos.writeObject(c);
			oos.flush();
		}
	}
}

class Car implements Serializable {
}