// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    
    public String solution(String S) {
        // write your code in Java SE 8
    	
    	StringBuilder sol = new StringBuilder();        
        for (String word : S.split(" ")){
        	sol.append(new StringBuilder(word).reverse()+" ");
    	}
        
    	return sol.toString();
    }
    
	public static void main(String[] args) {
		Solution s = new Solution();
		
		
		System.out.println(s.solution("we must behave"));
	}
    
    
    
}