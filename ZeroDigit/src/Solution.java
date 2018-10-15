
public class Solution {
	long numberZeroDigits(long n) {
		if (n == 0) {
			return 0;
		}
		long num5 = 0;
		for (long i = 5; n / i >= 1; i *= 5)
			num5 += n / i;
		return num5;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numberZeroDigits(2));
	}
}
