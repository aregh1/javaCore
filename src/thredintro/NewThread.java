package thredintro;

class NewThread implements Runnable {
	Thread t;

	NewThread() {
		// Create a new, second thread
		t = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + t);
		t.start(); // Start the thread
	}

	// This is the entry point for the second thread.
	public void run () {


		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("In RUN METHOD currentThread().getName(): " + Thread.currentThread().getName() );
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}

	public void join() throws InterruptedException {
		if(t != null){System.out.println("In RUN METHOD currentThread().getName(): " + Thread.currentThread().getName() );
			t.join();
		}
	}
}

class ThreadDemo {
	public static void main(String args[]) {
		NewThread newThread = new NewThread(); // create a new thread
		newThread.run();
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(500);
			}
//			newThread.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}
