public class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;
		if (nums == null || nums.length == 0) {
			return res;
		}
		res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(new Solution().singleNumber(new int[] { 1, 2, 3, 4,
				5, 6, 5, 4, 3, 2, 1 }));
	}
}
