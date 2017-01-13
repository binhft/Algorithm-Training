public class Solution {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 10;
		}
		int[] uniqueDigits = new int[n + 1];
		uniqueDigits[0] = 1;
		uniqueDigits[1] = 9;
		for (int i = 2; i < n + 1; i++) {
			if (i > 10) {
				break;
			} else {
				uniqueDigits[i] = uniqueDigits[i - 1] * (10 - (i - 1));
			}
		}

		int res = 0;
		for (int i = 0; i < n + 1; i++) {
			res += uniqueDigits[i];
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countNumbersWithUniqueDigits(1));
	}
}
