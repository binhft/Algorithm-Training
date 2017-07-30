public class Solution {
	public int maxA(int N) {
		int j;
		int max = 0;
		int temp;

		if (N <= 6)
			return N;

		for (j = N - 3; j > 0; j--) {
			temp = (N - j - 1) * maxA(j);
			if (temp > max) {
				max = temp;
			}
		}

		return max;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().maxA(4));
	}
}
