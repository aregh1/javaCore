package thredintro;

/**
 * Created by karenvardanyan on 12/10/16.
 */
public class TreadByRunnableInterface {
    public static void main(String[] args) {
        SomeRunnable someRunnable = new SomeRunnable();
        someRunnable.run();

        new Thread(someRunnable, "SomeRunnable Thread_1").start();
        Thread t = new Thread(someRunnable, "SomeRunnable Thread");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Before end of Main");
    }

}


class SomeRunnable implements Runnable {

    @Override
    public void run() {

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