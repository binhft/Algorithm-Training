import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	private String abb(String s, int k) {
		String res = s.substring(0, k) + (s.length() - k - 1 + "")
				+ s.charAt(s.length() - 1);
		if (res.length() >= s.length()) {
			res = s;
		}
		return res;
	}

	public List<String> wordsAbbreviation(List<String> dict) {
		List<String> res = new ArrayList<String>();

		for (int i = 0; i < dict.size(); i++) {
			String s = dict.get(i);
			for (int k = 1; k < s.length(); k++) {
				boolean isValid = true;
				String check = abb(s, k);
				for (int j = 0; j < dict.size(); j++) {
					if (j == i) {
						continue;
					}
					String anotherStr = dict.get(j);
					if (anotherStr.length() != s.length()) {
						continue;
					}

					if (check.equals(abb(anotherStr, k))) {
						isValid = false;
						break;
					}
				}

				if (isValid) {
					res.add(check);
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[] arr = new String[] { "abcdefg", "abccefg", "abcckkg" };
		System.out
				.println(new Solution().wordsAbbreviation(Arrays.asList(arr)));
	}
}
