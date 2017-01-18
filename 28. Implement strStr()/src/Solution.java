public class Solution {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int m = haystack.length();
		int n = needle.length();
		for (int start = 0; start < m - n + 1; start++) {
			int i = 0;
			while (i < n && needle.charAt(i) == haystack.charAt(start + i)) {
				i++;
			}
			if (i == needle.length()) {
				return start;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().strStr("a", "a"));
	}
}