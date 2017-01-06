public class Solution {
	public boolean isPowerOfTwo(int n) {
		return ((n & (n-1)) == 0 && n > 0);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().isPowerOfTwo(3));
	}
}
