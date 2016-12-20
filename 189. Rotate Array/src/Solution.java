public class Solution {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		if (k >= len) {
			k = k % len;
		}

		int[] newArr = new int[len];
		for (int i = 0; i < len; i++) {
			newArr[i] = nums[(i + (len -k)) % len];
		}
		for (int i = 0; i < len; i++) {
			nums[i] = newArr[i];
		}
//		nums = newArr;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
		new Solution().rotate(a, 2);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
