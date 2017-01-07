public class Solution {
	public boolean isMatch(String s, String p) {
//		System.out.println(s + " " + p);
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1) {
			if (s.length() == 0) {
				return false;
			}
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
				return isMatch(s.substring(1), p.substring(1));
			}
			return false;
		}

		if (p.charAt(1) != '*') {
			if (s.length() == 0) {
				return false;
			}

			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
				return isMatch(s.substring(1), p.substring(1));
			}
			return false;
		} else {
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			int i = 0;
			while (i < s.length()
					&& (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		String[] testStr = { "aaba" };

		String[] patternStr = { "ab*a*c*a" };

		for (int i = 0; i < testStr.length; i++) {
			// System.out.println(i);
			System.out.println(testStr[i] + " " + patternStr[i] + " "
					+ new Solution().isMatch(testStr[i], patternStr[i]));
		}
	}
}
