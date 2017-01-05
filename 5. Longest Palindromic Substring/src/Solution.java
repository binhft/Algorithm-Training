public class Solution {
	// public String longestPalindrome(String s) {
	// int maxLength = 0;
	// String longest = null;
	// int len = s.length();
	// boolean[][] dp = new boolean[len][len];
	//
	// for (int l = 0; l < s.length(); l++) {
	// for (int i = 0; i < s.length() - l; i++) {
	// int j = i + l;
	// if (s.charAt(i) == s.charAt(j)
	// && (j - i <= 2 || dp[i + 1][j - 1])) {
	// dp[i][j] = true;
	// if (j - i + 1 >= maxLength) {
	// maxLength = j - i + 1;
	// longest = s.substring(i, j + 1);
	// }
	// }
	//
	// }
	// }
	//
	// return longest;
	// }

	int maxLength = 0;
	int index = 0;

	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			extendStr(s, i, i);
			extendStr(s, i, i + 1);
		}

		return s.substring(index, index + maxLength);
	}

	private void extendStr(String s, int start, int end) {
		while (start >= 0 && end < s.length()
				&& s.charAt(start) == s.charAt(end)) {
			start--;
			end++;

		}
		if (end - start - 1 > maxLength) {
			maxLength = end - start - 1;
			index = start + 1;
		}
	}

	public static void main(String[] args) {
		System.out
				.println(new Solution()
						.longestPalindrome("bb"));
	}
}