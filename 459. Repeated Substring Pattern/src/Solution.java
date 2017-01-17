public class Solution {
	public boolean repeatedSubstringPattern(String str) {
		String new_str = str.substring(1) + str.substring(0, str.length() - 1);
		System.out.println(new_str);
		return new_str.contains(str);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().repeatedSubstringPattern("abcab"));
	}
}
