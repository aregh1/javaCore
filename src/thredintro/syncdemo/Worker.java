package thredintro.syncdemo;


public class Worker implements Runnable {
    static Object object = new Object();
    NumberHolder numberHolder;

    public Worker(NumberHolder numberHolder) {
        this.numberHolder = numberHolder;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            numberHolder.increaseNumber();
        }
    }
}