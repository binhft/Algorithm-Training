public class Solution {
	public boolean isPowerOfFour(int num) {
		if (num == 1) {
			return true;
		}
		return num > 0 && (Math.log10(num)/Math.log10(2) %2 == 0);
	}
	public static void main(String[] args) {
		int[] test = {0, 1, 2, 3, 4, 8, 16, 20};
		for (int i: test) {
			System.out.println(i + " " + new Solution().isPowerOfFour(i));
		}
	}
}
