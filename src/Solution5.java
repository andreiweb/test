public class Solution5 {

	public int solution(int M, int N) {

		char[] charM = getBinaryCharsArray(M);
		char[] charN = getBinaryCharsArray(N);
		
		int lengthM = charM.length;
		int lengthN = charN.length;

		int dif = lengthN - lengthM;
		
		char[] result = new char[lengthN];

		for (int i = lengthN - 1; i >= 0; i--) {

			if ((i - dif) >= 0) {

				if (charN[i] == '1' && charM[i - dif] == '1') {
					result[i] = (char) '1';
				} else {
					result[i] = (char) '0';
				}

			} else {
				result[i] = '0';
			}

		}
		
		String bitand = new String(result); 
		return Integer.parseInt(bitand, 2);
	}

	private char[] getBinaryCharsArray(int a) {

		String binnaryString = Integer.toBinaryString(a);

		return binnaryString.toCharArray();
	}

	public static void main(String[] args) {
		
		Solution5 s = new Solution5();
		System.out.println(s.solution(5,7));
		
		/*char[] c = new char[2];
		c[0] = '0';
		c[1] = '1';
		System.out.println(new String(c));
		
		
		int x = 21;*/
		//System.out.println(Integer.toBinaryString(x));
	}

}
