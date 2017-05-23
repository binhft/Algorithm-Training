public class Solution {
	public String reverseString(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		char[] charList = s.toCharArray();
		int low = 0;
		int high = charList.length - 1;

		while (low < high) {
			char c = charList[low];
			charList[low] = charList[high];
			charList[high] = c;
			low++;
			high--;
		}
		
		return new String(charList);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverseString("1234"));
	}
}
