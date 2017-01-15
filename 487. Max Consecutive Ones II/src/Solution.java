public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int[] start = new int[10000];
		int[] end = new int[10000];
		int count = 0;

		int left = -1;
		int right = -1;
		int res = 0;
		for (int i = 0; i <= nums.length; i++) {
			int value = (i == nums.length) ? 0 : nums[i];
			if (value == 1) {
				if (left == -1) {
					left = i;
				}
				right = i;
			} else {

				if (left != -1 && right != -1) {
					// System.out.println(left + " " + right);
					start[count] = left;
					end[count] = right;
					res = Math.max(res, (right - left + 1));
					count++;
				}
				left = -1;
				right = -1;
			}
		}

		for (int i = 1; i < count; i++) {
			if (start[i] == end[i - 1] + 2) {
				res = Math.max(res, end[i] - start[i - 1] + 1);
			} else if (start[i] > end[i - 1] + 2) {
				res = Math.max(res, end[i] - start[i] + 2);
				res = Math.max(res, end[i - 1] - start[i - 1] + 2);
			}
		}
		if (count > 0) {
			if (end[count - 1] < nums.length - 1) {
				// System.out.println(end[count - 1]);
				res = Math.max(res, end[count - 1] - start[count - 1] + 2);
			}
			if (start[0] > 0) {
				res = Math.max(res, end[0] - start[0] + 2);
			}
		} else {
			return 1;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMaxConsecutiveOnes(new int[] { 0,
				0 }));
	}
}
