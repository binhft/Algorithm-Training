public class Solution {
	public int reverse(int x) {

		char[] c = String.valueOf(x).toCharArray();
		int low = 0;
		int high = c.length - 1;
		if (c[0] == '-') {
			low = 1;
		}

		while (low < high) {
			char temp = c[low];
			c[low] = c[high];
			c[high] = temp;
			low++;
			high--;
		}
		
		int res = 0;
		try {
			res = Integer.valueOf(String.valueOf(c));
		} catch (Exception ex) {
			return 0;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverse(-123));
	}
}