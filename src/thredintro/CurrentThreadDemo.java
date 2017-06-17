package thredintro;

/**
 * Created by karenvardanyan on 12/10/16.
 */
public class CurrentThreadDemo {

	public static void main(String[] args) {
		Thread currentThread= Thread.currentThread();
		System.out.println(currentThread);
		for (int i = 0; i < 100; i++) {
			long startTime = System.currentTimeMillis();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long duration = System.currentTimeMillis() - startTime;
			System.out.println(duration);
		}

	}
}
