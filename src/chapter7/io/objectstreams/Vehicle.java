package chapter7.io.objectstreams;

import java.io.*;

class Vehicle {
	String name = "Vehicle";
}

class Car1 extends Vehicle implements Serializable {
	String model = "Luxury";
}

class ParentNotSerializable {
	public static void main(String args[]) throws Exception {

		try (
			FileOutputStream out = new FileOutputStream("object.data");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			FileInputStream in = new FileInputStream("object.data");
			ObjectInputStream ois = new ObjectInputStream(in);
		) {
			Car1 c = new Car1();
			oos.writeObject(c);
			oos.flush();
			Car1 c2 = (Car1) ois.readObject();
			System.out.println(c2.name + ":" + c2.model);
		}
	}
}
