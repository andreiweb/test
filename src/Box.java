public class Box extends Thread {

	public void run() {
		for (int i = 1; i < 100; i++) {
			System.out.println(i);
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		Thread T1 = new Box();
		Thread T2 = new Box();
		T1.start();
		T2.start();
	}

}