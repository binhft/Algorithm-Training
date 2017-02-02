import java.util.HashMap;

public class Solution {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			if (s != null || t != null) {
				return false;
			}
			return true;
		}

		if (s.length() != t.length()) {
			return false;
		}

		int count = s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
//		System.out.println(map);

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!map.containsKey(c) || map.get(c) <= 0) {
				return false;
			} else {
				map.put(c, map.get(c) - 1);
				count--;
			}

		}
//		System.out.println(map);

		return count == 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isAnagram("anagram", "nagaram"));
	}
}
