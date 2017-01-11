public class Solution {
	public int numSquares(int n) {
		int[] numSquare = new int[n + 1];
		numSquare[0] = 0;
		numSquare[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			int limit = (int) Math.sqrt(i);
			numSquare[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= limit; j++) {
				numSquare[i] = Math.min(numSquare[i], 1 + numSquare[i - j*j]);
			}
//			System.out.println("i=" + i + " then " + numSquare[i]);
		}

		return numSquare[n];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numSquares(1000000));
	}
}
