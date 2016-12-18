public class Solution {
	public int[] plusOne(int[] digits) {

		int carry = 0;

		digits[digits.length - 1] += 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int res = digits[i] + carry;
			digits[i] = res % 10;
			carry = res / 10;
//			System.out.println(carry);
		}

		int[] res;
		if (carry > 0) {
			res = new int[digits.length + 1];
			res[0] = carry;
			for (int i = 0; i < digits.length; i++) {
				res[i + 1] = digits[i];
			}
		} else {
			res = digits;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] res = new Solution().plusOne(new int[] { 9, 9, 9 });
		for (Integer i: res) {
			System.out.println(i);
		}
	}
}
