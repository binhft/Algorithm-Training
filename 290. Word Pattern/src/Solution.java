import java.util.HashMap;

public class Solution {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null) {
			if (str == null) {
				return true;
			}

			return false;
		}
		String[] splited = str.split("\\s+");
		HashMap<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			if (i >= splited.length) {
				return false;
			}
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c).equals(splited[i])) {
					continue;
				} else {
					return false;
				}
			} else {
				map.put(c, splited[i]);
			}
		}

		HashMap<String, Character> mapStr = new HashMap<>();
		for (int i = 0; i < splited.length; i++) {
			if (i >= pattern.length()) {
				return false;
			}
			String tmp = splited[i];
			if (mapStr.containsKey(tmp)) {
				if (mapStr.get(tmp).equals(pattern.charAt(i))) {
					continue;
				} else {
					return false;
				}
			} else {
				mapStr.put(tmp, pattern.charAt(i));
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog dog dog dog";

		System.out.println(new Solution().wordPattern(pattern, str));
	}
}
