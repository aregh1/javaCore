package thredintro;

//       [Hello]
//       [World]
//       [Synchronized]

public class SynchDemo {
	public static void main(String args[]) {

		Printer target = new Printer();
		Caller ob1 = new Caller("C1", target, "Hello");
		Caller ob2 = new Caller("C2", target, "Synchronized");
		Caller ob_Other = new Caller("C3", new Printer(), "Other Printer Text");
		Caller ob3 = new Caller("C3", target, "World");


		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}


// This program is not synchronized.
class Printer {

	Object object = new Object();

	void print(String msg) throws InterruptedException {
//		synchronized (object) {

			System.out.print("[" + msg);
			Thread.sleep(10);
			System.out.println("]");
//		}

	}
}

class Caller implements Runnable {
	String msg;
	Printer printer;
	Thread t;

	public Caller(String threadName, Printer printer, String msg) {
		this.printer = printer;
		this.msg = msg;
		t = new Thread(this, threadName);
		t.start();
	}

	@Override
	public void run() {
		try {
			printer.print(msg);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
