public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			count += 1;
		}
		
		return n << count;
	}
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(new Solution().rangeBitwiseAnd(5, 7));
	}
}
