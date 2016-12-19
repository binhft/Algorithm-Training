public class Solution {
	public int minDistance(String word1, String word2) {
		int[][] res = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			res[i][0] = i;
		}
		
		for (int j = 0; j <= word2.length(); j++) {
			res[0][j] = j;
		}
		
		for (int i = 0; i < word1.length(); i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < word2.length(); j++) {
				char c2 = word2.charAt(j);
				
				if (c1 == c2) {
					res[i + 1][j + 1] = res[i][j];
				} else {
					int replace = res[i][j] + 1;
					int insert = res[i][j+1] + 1;
					int delete = res[i+1][j] + 1;
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					res[i + 1][j + 1] = min;
				}
			}
		}
		
		return res[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().minDistance("abc", "a"));
	}
}
