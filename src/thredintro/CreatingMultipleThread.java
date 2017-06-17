package thredintro;

/**
 * Created by karenvardanyan on 12/10/16.
 */
public class CreatingMultipleThread {

	public static void main(String[] args) throws InterruptedException {
		YourThread thread1 = new YourThread("kukich_1");
		YourThread thread2 = new YourThread("kukich_2");
        thread1.sayHey();
		thread1.start();
		thread2.start();
		thread1.join();
		System.out.println("thread1.isAlive(): " + thread1.isAlive());
		System.out.println("thread2.isAlive(): " + thread2.isAlive());
	}

}

class YourThread extends Thread {
	public YourThread(String name) {
		super(name);
	}

	public void sayHey(){
		System.out.println(Thread.currentThread().getName());
		System.out.println("Say Hey!!!");
	}

	@Override
	public void run(){
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
