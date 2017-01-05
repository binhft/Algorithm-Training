import java.util.HashSet;

public class Solution {
	public int longestPalindrome(String s) {
		int result = 0;
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				result += 2;
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		
		if (!set.isEmpty()) {
			result += 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("abccccdd"));
	}
}