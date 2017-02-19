public class Solution {
	public boolean detectCapitalUse(String word) {
		if (word.toUpperCase().equals(word)) {
//			System.out.println("Case 1");
			return true;
		} else if (word.toLowerCase().equals(word)) {
//			System.out.println("Case 2");
			return true;
		} else if (word.substring(0, 1).toUpperCase().equals(word.substring(0,1)) && word.substring(1).toLowerCase().equals(word.substring(1))) {
//			System.out.println(word.substring(1));
//			System.out.println("Case 3");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().detectCapitalUse("FlaG"));
		System.out.println(new Solution().detectCapitalUse("Leetcode"));
	}
}
