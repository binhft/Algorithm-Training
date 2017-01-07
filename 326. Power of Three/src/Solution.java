public class Solution {
	public boolean isPowerOfThree(int n) {
		if (n > 1) {
			while (n % 3 == 0) {
				n = n / 3;
			}
		}
		if (n == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] test = { 1, 3, 5, 10, 27 };
		for (Integer i : test) {
			System.out.println(new Solution().isPowerOfThree(i));
		}
		System.out.println(3.3%1.2);
	}
}
