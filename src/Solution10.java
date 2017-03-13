import java.util.ArrayList;
import java.util.List;

public class Solution10 {

	
	public static int[] getComponents(int i){
		
		String sarray = new String(""+i);
		char[] chArray = sarray.toCharArray();
		
		int length = sarray.length();
		
		
		List<Integer> d = new ArrayList<Integer>();
		
		int idx = 0;
		for (char c : chArray) {
				
			if (c!='0') {
				d.add((int)Math.pow(10, length-idx)*Integer.parseInt(""+c));
			}
		}
		
		int[] ret = new int[d.size()];
		
		/*for (int x = 0; x<d.size();x++) {
			ret[x] = d.get(x); 
		}*/
		
		return ret;
	}
	
	
	public static void main(String[] args) {
		
		int[] a = getComponents(25607);
		
		for (int x:a) {
			System.out.println("p:"+x);	
		}
		
	}
	
}
