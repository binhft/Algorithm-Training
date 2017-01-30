import java.util.HashMap;

public class Solution {
	public String minWindow(String s, String t) {
		if (s == null || t == null) {
			return null;
		}

		int left = 0;
		int right = 0;
		int head = -1;
		int len = Integer.MAX_VALUE;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int counter = map.size();
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					counter--;
				}
			}

			right++;

			while (counter == 0) {
				char temp = s.charAt(left);
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
					if (map.get(temp) > 0) {
						counter++;
					}
				}

				if (right - left < len) {
					len = right - left;
					head = left;
				}

				left++;
			}
		}

		if (len == Integer.MAX_VALUE)
			return "";
		return s.substring(head, head + len);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
	}
}
