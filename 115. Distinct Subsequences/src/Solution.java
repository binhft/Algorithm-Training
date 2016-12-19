public class Solution {
	public int numDistinct(String s, String t) {
		int len1 = s.length();
		int len2 = t.length();

		int[][] res = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i <= len1; i++) {
			res[i][0] = 1;
		}

//		for (int j = 0; j <= len2; j++) {
//			res[0][j] = 0;
//		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
				} else {
					res[i][j] = res[i - 1][j];
				}

			}
		}

		return res[len1][len2];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));
	}
}
