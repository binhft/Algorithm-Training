public class Solution {
	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
		return bitCount(xor);
	}
	
	private int bitCount(int n) {
		int count = 0;
		while (n > 0) {
			n = n & (n-1);
			count += 1;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().hammingDistance(1, 4));
	}
}
