public class Solution {
	public String countAndSay(int n) {
		String res = new String("1");
		for (int i = 2; i <= n; i++) {
			res = helper(res);
		}
		return res;
	}

	private String helper(String s) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = 1;
			while (i + 1 < s.length() && s.charAt(i + 1) == c) {
				i++;
				count++;
			}
			sb.append(count).append(c);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().countAndSay(3));
	}
}
