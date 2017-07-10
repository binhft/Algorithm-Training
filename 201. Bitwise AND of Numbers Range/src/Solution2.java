public class Solution2 {

	public int rangeBitwiseAnd(int m, int n) {
		int r = Integer.MAX_VALUE;
		while ((n & r) != (m & r)) {
			r = r << 1;
		}
		return n & r;

	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(new Solution2().rangeBitwiseAnd(5, 7));
	}

}
