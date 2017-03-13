import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public final class Test {
	
	private final String name;
	
	Test(String name) {
		this.name = name;
	}
	
	public void mu(final String a, final String b) {
		
		final String name;
		final String age;
		
		name = "";
		
		
	}
	
	private static String reverse(String str) {

		//System.out.println("reverse:"+str);
		if ((null == str) || (str.length() <= 1)) {
			return str;
	    }
		
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) {
	
		//System.out.println(reverse("Andrei"));
		
		//System.out.println(Math.abs(-123 % 25));
		
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        
        String s = scan.nextLine();
        String s2 = scan.nextLine();
        
        System.out.println(i);
        System.out.println(d);
        System.out.println(s);
		
	}
	
	
}