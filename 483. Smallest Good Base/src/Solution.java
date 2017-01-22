public class Solution {
	public String smallestGoodBase(String n) {
		long num = 0;
		for (int i = 0; i < n.length(); i++) {
			num = num * 10 + n.charAt(i) - '0';
		}
		long x = 1;
		for (long p = 2; p < 100; p++) {
			if ((x << p) <= num) {
				long k = helper(num, p);
				if (k != -1) {
					return String.valueOf(k);
				}
			}
		}

		return String.valueOf(num - 1);

	}

	private long helper(long num, long p) {
		long l = 1;
		long r = (long) (Math.pow(num, 1.0 / p) + 1);
		while (l < r) {
//			System.out.println(l + " " + r);
			long sum = 0;
			long mid = (r - l) / 2 + l;
			long current = 1;
			for (int i = 0; i <= p; i++) {
				sum = sum + current;
				current = current * mid;
			}

			if (sum == num)
				return mid;
			else if (sum > num) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().smallestGoodBase("10"));
	}
}
