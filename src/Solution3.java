
public class Solution3 {
	
	public int solution (int[] A) {
		
		int currentSlice = 0;
	    int maxAlternatingSlice = 0;
	    
	    if  (A.length  <=  1) {
	        return A.length;
	    }
	    
	    int i = 0;
	    
	    while (i  <  A.length && A[i]  ==  0)   {//if starts with 0 - increase slice size
	        currentSlice++;
	        i++;
	    }
	    
	    if  (i  <  A.length)  {
	        int zeroSign = 0;
	        int previousNonZero  =  A[i];
	        currentSlice++;
	        i++;
	        while  (i  <  A.length)  {
	        	
	        	
				System.out.println("zeroSign:" + zeroSign + " zeroSign%2:" + (zeroSign % 2));
	        	
	            if  (A[i]  ==  0)  {
	                currentSlice++;
	                zeroSign++;
	            } else {
	                if  ((A[i]  >  0  &&  previousNonZero  >  0)  ||  (A[i]  <  0  &&  previousNonZero  <  0))  {
	                    if  (zeroSign  >  0)  {
	                        if  (zeroSign % 2  ==  1) {
	                            currentSlice  +=  1;
	                        }
	                        else {
	                            maxAlternatingSlice  =  Math.max(maxAlternatingSlice,  currentSlice);
	                            currentSlice  =  zeroSign  +  1;
	                        }
	                        
	                        zeroSign  =  0;
	                    }
	                    else {
	                        maxAlternatingSlice  =  Math.max(maxAlternatingSlice,  currentSlice);
	                        currentSlice  =  zeroSign  + 1;
	                    }
	                }
	                else {
	                    if  (zeroSign  ==  0) {
	                        currentSlice++;
	                    }
	                    else {
	                        if  (zeroSign % 2  ==  0)  {
	                            currentSlice  +=  1;
	                        }
	                        else {
	                            maxAlternatingSlice  =  Math.max(maxAlternatingSlice, currentSlice);
	                            currentSlice  =  zeroSign + 1;
	                        }
	                        zeroSign  =  0;
	                    }
	                }
	                previousNonZero  =  A[i];
	            }
	            i++;
	        }
	    }
	    maxAlternatingSlice  =  Math.max(maxAlternatingSlice, currentSlice);
	    
	    return maxAlternatingSlice;
	 }
	
	
	
	
	
	public static void main(String[] args) {
		
		Solution3 s = new Solution3();
		
		int[] a = {0,4,-3,2,0,0,0,0,1,-1,0, 0, 0,2,-3,4,-5};
		
		System.out.println(s.solution(a));
		
		System.out.println(""+-16%2);
	}
	
	
}
