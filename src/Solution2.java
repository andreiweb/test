
public class Solution2 {

	public String solution(String S, String T) {

		if (S.equals(T)) {
			return "NOTHING";
		}

		String response = checkINSERT(S, T);

		if (response != null) {
			return "INSERT " + response;
		}
		
		response = checkDELETE(S, T);
		if (response != null) {
			return "DELETE " + response;
		}
		
		response = checkSWAP(S, T);
		if (response != null) {
			return "SWAP " + response;
		}

		return "IMPOSSIBLE";// nothing works
	}

	// check for insertion
	private String checkINSERT(String S, String T) {
		
		//does not make sense to continue if there is more than one character different
		if (S.length() + 1 != T.length()) { 
			return null;
		}
		
		char[] charsS = S.toCharArray();
		char[] charsT = T.toCharArray();

		for (int iT = 0; iT < charsT.length; iT++) {
			if (iT == charsT.length - 1) { // check at the end
				String SPlusChar = S + charsT[iT];
				if (SPlusChar.equals(T)) {
					return String.valueOf(charsT[iT]);
				} else {
					return null;
				}
			}
			if (charsS[iT] != charsT[iT]) { // check in the middle
				String SPlusChar = S.substring(0, iT) + charsT[iT] + S.substring(iT, charsS.length);
				if (SPlusChar.equals(T)) {
					return String.valueOf(charsT[iT]);
				} else {
					return null;
				}
			} else {
				continue;//if chars are equal continue with the rest of them
			}
		}

		return null;
	}

	private String checkDELETE(String S, String T) {
		
		//does not make sense to continue if there is more than one character different
		if (S.length() - 1 != T.length()) {
			return null;
		}
		
		char[] charS = S.toCharArray();
		char[] charT = T.toCharArray();

		for (int iS = 0; iS < charS.length; iS++) {
			if (iS == charS.length - 1) {//check at the end 
				String SMinusChar = S.substring(0, charS.length - 1);
				if (SMinusChar.equals(T)) {
					return String.valueOf(charS[iS]);
				} else {
					return null;
				}
			}
			if (charS[iS] != charT[iS]) {//check in the middle
				String SMinusChar = S.substring(0, iS) + S.substring(iS + 1, charS.length);
				if (SMinusChar.equals(T)) {
					return String.valueOf(charS[iS]);
				} else {
					return null;
				}
			} else {
				continue;
			}
		}

		return null;
	}

	private String checkSWAP(String S, String T) {
		
		//does not make sense to continue if are not equal
		if (S.length() != T.length()) {
			return null;
		}
		
		char[] charS = S.toCharArray();
		
		for (int iS = 0; iS < charS.length - 1; iS++) {
			
			swapValues(iS, iS + 1, charS);
			
			if (T.equals(new String(charS))) {
				return charS[iS + 1] + " " + charS[iS];
			}
			
			swapValues(iS, iS + 1, charS);
			
		}
		return null;
	}

	private void swapValues(int a, int b, char[] arrayOfChars) {
		char last = arrayOfChars[a];
		arrayOfChars[a] = arrayOfChars[b];
		arrayOfChars[b] = last;
	}
	
	
	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		System.out.println(s2.solution("aban", "aban"));
	}

}
