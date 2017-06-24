package thredintro;

/**
 * Created by karenvardanyan on 12/17/16.
 */
public class PriorityDemo {
	public static void main(String[] args) throws InterruptedException {
		Clicker low = new Clicker("Low Priority", 1);
		Clicker hi  = new Clicker("High Priority", 10);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		low.stop();
		hi.stop();

		hi.join();
		low.join();

		System.out.println("hi.clickCount  : " + hi.clickCount);
		System.out.println("low.clickCount : " + low.clickCount);

	}
}

class Clicker implements Runnable {
	 volatile long clickCount;
	 boolean isRunning;
 	 Thread t;

	public Clicker(String name, int priority) {
		isRunning = true;
		t = new Thread(this, name);
		t.setPriority(priority);
		t.start();
	}

	void stop() {
		isRunning = false;
	}

	void join() throws InterruptedException {
		t.join();
	}

	@Override
	public void run() {
		while (isRunning) {
			clickCount++;
		}
	}
}