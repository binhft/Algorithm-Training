public class Solution {
	public double myPow(double x, int n) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == Integer.MIN_VALUE) {
			n = n / 2;
			x = x * x;
		}
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().myPow(10, -2147483648));
	}
}
