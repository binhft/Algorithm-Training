import java.util.HashSet;
import java.util.Set;

public class Solution {
	public String addBoldTag(String s, String[] dict) {
		Set<String> set = new HashSet<String>();
		for (String item : dict) {
			set.add(item);
		}
		boolean[] bold = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int count = 0;
			for (String dictStr : dict) {
				if (i + dictStr.length() <= s.length()
						&& s.substring(i, i + dictStr.length()).equals(dictStr)) {
					count = Math.max(count, dictStr.length());
				}
			}
			for (int j = i; j < i + count; j++) {
				bold[j] = true;
			}
		}

		StringBuilder res = new StringBuilder();
		boolean wasBold = false;
		for (int i = 0; i < s.length(); i++) {
			if (bold[i]) {
				if (!wasBold) {
					res.append("<b>");
				}
				res.append(s.charAt(i));
				wasBold = true;
			} else {
				if (wasBold) {
					res.append("</b>");
				}
				res.append(s.charAt(i));
				wasBold = false;
			}
		}
		if (wasBold) {
			res.append("</b>");
		}

		return res.toString();
	}

	public static void main(String[] args) {
		String s = "aaabbcc";
		System.out.println(new Solution().addBoldTag(s, new String[] { "aaa",
				"aab", "bc", "aaabbcc" }));
	}
}
