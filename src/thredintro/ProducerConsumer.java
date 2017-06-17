package thredintro;


public class ProducerConsumer {
	public static void main(String args[]) throws InterruptedException {
		Q q = new Q();

		new Producer(q);
		new Consumer(q);

	//	System.out.println("Press Control-C to stop.");
	}
}

// An incorrect implementation of a producer and consumer.
class Q {
	int n;
	boolean isValueSet = true;

	synchronized int get() {
		while (!isValueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// this can be available if isValueSet == true
		System.out.println("Got: " + n);
		isValueSet = false;

		notify();
		return n;
	}

	synchronized void put(int n) {
		while (isValueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.n = n;
		System.out.println("Put: " + n);
		isValueSet = true;
		notify();
	}
}

class Producer implements Runnable {
	Q q;

	Producer(Q q) throws InterruptedException {
		this.q = q;
		Thread.sleep(10);
		new Thread(this, "Producer").start();
	}

	public void run() {
		int i = 0;
		while (i < 100) {
			q.put(i++);
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (q){

		}

	}
}

class Consumer implements Runnable {
	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		int i = 0;
		while (i++ < 100) {
			q.get();
		}
	}


}

