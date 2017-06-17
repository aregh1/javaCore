package thredintro.yield;

public class YieldExample {
	public static void main(String[] args) {
		Thread producer = new Producer();
		Thread consumer = new Consumer();

//		producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
//		consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

		producer.start();
		consumer.start();
	}
}

class Producer extends Thread {
	public void run() {
		for (int i = 0; i < 5000; i++) {
			System.out.println("Producer : " + i);
			Thread.yield();
		}
	}
}

class Consumer extends Thread {
	public void run() {
		for (int i = 0; i < 5000; i++) {
			System.out.println("Consumed " + i);
			Thread.yield();
		}
	}
}