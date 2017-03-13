import java.util.ArrayList;
import java.util.List;

class TD extends Thread {
   private Thread t;
   private String threadName;
   PrintDemo  PD;
   static  Integer idx = 1;

   TD( String name,  PrintDemo pd) {
      threadName = name;
      PD = pd;
   }
   
   public void run() {
      
      PD.printCount();
      idx++;
      
      System.out.println("Thread " +  threadName + " exiting.");
   }

  
}

public class TestThread2 {

	public static void main(String args[]) {

		PrintDemo PD = new PrintDemo();

		List<TD> list = new ArrayList<TD>();

		for (int i = 0; i < 100000; i++) {

			TD td = new TD("Thread - " + i, PD);
			list.add(td);

			td.start();

		}

		// wait for threads to end
/*		try {

			for (int i = 0; i < 100000; i++) {
				list.get(i).join();
			}
		} catch (Exception e) {
			System.out.println("Interrupted");
		}*/
		
		System.out.println("idx:"+TD.idx);

	}
}
