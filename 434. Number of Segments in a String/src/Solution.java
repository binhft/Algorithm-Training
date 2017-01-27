public class Solution {
	public int countSegments(String s) {
		int res = 0;
		if (s == null || s.length() == 0) {
			return res;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i-1) == ' ')) {
				res += 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().countSegments(" Hello, my name   is John"));
	}
}
