public class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[][] max = new int[nums.length][2];

		for (int i = 1; i <= nums.length - 1; i++) {
			max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]);
			max[i][1] = max[i - 1][0] + nums[i - 1];
		}
		int max1 = Math.max(max[nums.length - 1][0], max[nums.length - 1][1]);

		int[][] max2 = new int[nums.length][2];
		for (int i = 2; i <= nums.length - 2; i++) {
			max2[i][0] = Math.max(max2[i - 1][0], max2[i - 1][1]);
			max2[i][1] = max2[i - 1][0] + nums[i - 1];
		}
		int max3 = Math.max(max2[nums.length - 2][0], max2[nums.length - 2][1])
				+ nums[nums.length - 1];
		return Math.max(max1, max3);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().rob(new int[] { 2 }));
		System.out.println(new Solution().rob(new int[] { 1, 2, 3, 1 }));
	}
}
