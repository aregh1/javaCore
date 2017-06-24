package thredintro;


public class StaticNonStaticSync {

	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		Sync sync1 = new Sync(Sync.Mode.FIRST , null);
		Sync sync2 = new Sync(Sync.Mode.SECOND, obj);
		Sync sync3 = new Sync(Sync.Mode.THIRD , obj);
		Sync sync4 = new Sync(Sync.Mode.FORTH , null);
		Thread.sleep(10);
		sync3.nonStatM();
		sync1.t.join();
		sync2.t.join();
		sync3.t.join();
		sync4.t.join();

	}
}



class Sync implements Runnable {
	enum Mode {
		FIRST("First"),
		SECOND("Second"),
		THIRD("Third"),
		FORTH("Forth");

		Mode(String name){
			this.name = name;
		}

		public static Mode findByName(String name){
			for (Mode mode : values()) {
				if(mode.name.equals(name)){
					return mode;
				}
			}
			return null;
		}

		private String name;
	}

	Object obj = new Object();
	Thread t;

	Mode mode;


	public Sync(Mode mode, Object obj) {
		this.mode = mode;
		this.obj = obj;
		t = new Thread(this);
		t.start();
	}

	synchronized static void statM() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("In statM: ");
	}

	void syncBlockM2() throws InterruptedException {
		System.out.println("before syncBlockM2: ");
		synchronized (obj) {
			Thread.sleep(100);
			System.out.println("In syncBlockM2: ");
		}
	}

	void syncBlockM() throws InterruptedException {

		System.out.println("before syncBlockM: ");
		synchronized (obj) {
			Thread.sleep(100);
			System.out.println("In syncBlockM: ");
		}
	}

	synchronized void nonStatM() throws InterruptedException {
		Thread.sleep(20);
		System.out.println("In nonStatM: ");
	}

	@Override
	public void run() {
		try {
			switch (mode) {
				case FIRST:
					statM();
					break;
				case SECOND:
					syncBlockM2();
					break;
				case THIRD:
					syncBlockM();
					break;
				case FORTH:
					nonStatM();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class EnumImitation {
	public static final EnumImitation FIRST  =  new EnumImitation("First");
	public static final EnumImitation SECOND =  new EnumImitation("Second");
	public static final EnumImitation THIRD  =  new EnumImitation("Third");
	public static final EnumImitation FORTH  =  new EnumImitation("Forth");


	private EnumImitation(String name){
		this.name = name;
	}

	private String name;
}