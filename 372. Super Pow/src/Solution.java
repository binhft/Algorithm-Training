public class Solution {
	int base = 1337;

	private int pow(int a, int k) {
		a %= base;
		int result = 1;
		for (int i = 0; i < k; i++) {
			result = (a * result) % base;
		}
		return result;
	}

	public int superPow(int a, int[] b) {
		int result = 1;
		a %= base;
		for (int i = b.length - 1; i >= 0; i--) {
			result = (result * pow(a, b[i])) % base;
			a = pow(a, 10);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().superPow(10, new int[]{1,2,3}));
	}
}
