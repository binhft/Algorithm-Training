public class Solution {
	public String reverseStr(String s, int k) {
		if (s == null || s.length() == 0 || k <= 0) {
			return s;
		}

		char[] charArr = s.toCharArray();
		int i = 0;
		int len = s.length();
		while (i * k < len) {
			if (i % 2 == 0) {
				int start = i * k;
				int end = Math.min((i + 1) * k - 1, len - 1);
				reverse(charArr, start, end);
			}
			i++;
		}

		return String.valueOf(charArr);
	}

	private void reverse(char[] c, int start, int end) {
		while (start <= end) {
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverseStr("abc", 4));
	}

}
