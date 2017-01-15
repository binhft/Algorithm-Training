public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int res = 0;
		int left = -1;
		int right = -1;
		for (int i = 0; i <= nums.length; i++) {
			int value = (i == nums.length ? 0 : nums[i]);
			if (value == 1) {
				if (left == -1) {
					left = i;
				}
				right = i;
			} else {
//				System.out.println(left + " " + right);
				if (left != -1 && right != -1) {
					res = Math.max(res, (right - left + 1));
				}
				left = -1;
				right = -1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMaxConsecutiveOnes(new int[] {  }));
	}
}
