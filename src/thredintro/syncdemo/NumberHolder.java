package thredintro.syncdemo;


public class NumberHolder {

	volatile int number;

	public static void main(String[] args) {
		NumberHolder numberHolder1 = new NumberHolder();
		NumberHolder numberHolder2 = new NumberHolder();

		Worker w1 = new Worker(numberHolder1);
		Worker w2 = new Worker(numberHolder2);
		Thread t1 = new Thread(w1 ,"W1");
		Thread t2 = new Thread(w2, "W2");
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("number = " + numberHolder1.number);
		System.out.println("number = " + numberHolder2.number);
	}

	public void increaseNumber(){
		number = number + 1;
	}
}
