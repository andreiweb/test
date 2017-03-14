import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Producer implements Runnable {

	public static final Object mutex = new Object();

	@Override
	public void run() {
		synchronized (mutex) {
			for (int i=0;i<100;i++) {
				try {
					Thread.sleep(1);
					System.out.println("Produce:"+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			mutex.notifyAll();
		}
	}

}

class Consumer implements Runnable {
	
	private String name;
	
	public Consumer(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		synchronized (Producer.mutex) {
			try {
				Producer.mutex.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			for (int i=0;i<10;i++) {
				System.out.println("consumer["+name+"]:"+i);
			}
		}
		
	}
}

public class TestThread3 {

	public static void main(String args[]) {

		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(new Consumer("c1"));
		es.execute(new Producer());
		es.execute(new Consumer("c2"));
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		es.shutdown();
	}
}
