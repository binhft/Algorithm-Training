public class Solution {
	public int findIntegers(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 2;
		}
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(num))
				.reverse();
		int n = sb.length();
		int[] a = new int[n];
		int[] b = new int[n];
		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		int res = a[n - 1] + b[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (sb.charAt(i) == '0' && sb.charAt(i+1) == '0') {
				res -= b[i];
			} else if (sb.charAt(i) == '1' && sb.charAt(i+1) == '1') {
				break;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findIntegers(5));
	}
}
