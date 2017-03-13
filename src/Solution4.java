
public class Solution4 {

	public int solution(int[] A) {

		if (A.length == 0) {
			return -1;
		}

		int M = getAverage(A);

		int maximalDeviation = 0;
		int idx = 0;
		for (int i = 0; i < A.length; i++) {

			int deviation = Math.abs(A[i] - M);

			if (deviation > maximalDeviation) {
				idx = i;
				maximalDeviation = deviation;
			}

		}

		return idx;
	}

	private int getAverage(int[] A) {

		int sum = 0;
		for (int i : A) {
			sum += i;
		}

		return sum / A.length;
	}

}
