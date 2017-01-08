public class Solution {
	public int arrangeCoins(int n) {
		long val = (long)n * 2;
		long res = (long) Math.floor(Math.sqrt(val));
		if (res * (res + 1) > val) {
			res = res - 1;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().arrangeCoins(1804289383));
	}
}
