import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		if (s == null) {
			return res;
		}

		Set<Character> set = new HashSet<Character>();

		int left = 0;
		int right = 0;

		int n = s.length();

		while (left < n && right < n) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				res = Math.max(right - left + 1, res);
				right++;
			} else {
				set.remove(s.charAt(left));
				left++;
			}
		}

		return res;

	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
	}
}
