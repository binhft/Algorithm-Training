public class Solution {
	public String reverseWords(String s) {
		if (s == null) {
			return null;
		}
		String[] parts = s.split("\\s+");
		
		StringBuilder res = new StringBuilder();
		for (int i = parts.length - 1; i >= 0; i--) {
			res.append(parts[i] + " ");
		}
		
		return res.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverseWords("the sky is blue"));
	}
}
