public class Solution {
	public String convertTo7(int num) {
		return Integer.toString(num, 7);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().convertTo7(-7));
	}
}
