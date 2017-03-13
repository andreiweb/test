
import java.util.ArrayList;
import java.util.List;

public class BusySpinDemo {
	
	public static long initialTime;
	static Object monitor = new Object();
	
    public static void main(String[] args) {
    	
    	initialTime = System.currentTimeMillis();
    	
        ProdThread pt = new ProdThread();
        Thread t1 = new Thread(pt, "Producer");
        // passing producer thread in consumer thread
        Thread t2 = new Thread(new ConThread(pt), "Consumer");
        t1.start();
        t2.start();    
    }
}

// Producer thread
class ProdThread implements Runnable{
    List<Integer> sharedListObj;
    boolean flag;
    ProdThread(){
        System.out.println("Constructor ProdThread");
        this.sharedListObj = new ArrayList<Integer>();
        this.flag = true;
    }
    @Override
    public void run() {
        System.out.println(" ProdThread run");
        
        synchronized(BusySpinDemo.monitor) {
        for(int i = 0; i < 5; i++){
            System.out.println("Adding to queue - " + Thread.currentThread().getName() + " " + i);
            sharedListObj.add(i);
        }
        BusySpinDemo.monitor.notify();
        }
        flag = false;        
    }            
}

// Consumer thread
class ConThread implements Runnable {
    ProdThread pt;
    ConThread(ProdThread pt){
        System.out.println("Constructor ConThread");
        this.pt = pt;
    }
    @Override
    public void run() { 
      // Busy spinning loop   
        /*while(this.pt.flag){
        	System.out.println("Waiting busy spinning");
        }*/
        
        synchronized(BusySpinDemo.monitor) {
        	try {
        		System.out.println("Waiting silently with waiting");
				BusySpinDemo.monitor.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
        
        System.out.println("Consumer starting");
        for(Integer i: this.pt.sharedListObj){
            System.out.println("" + i);
        }
        
        System.out.println("time spent:" + (System.currentTimeMillis()-BusySpinDemo.initialTime)+"ms");
    }
}
