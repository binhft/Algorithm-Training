public class Solution {
	public int findPeakElement(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private int helper(int[] nums, int low, int high) {
		if (low == high) {
			return low;
		}

		int mid = low + (high - low) / 2;
		if (nums[mid] > nums[mid + 1]) {
			return helper(nums, low, mid);
		} else {
			return helper(nums, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findPeakElement(new int[] { 1, 2, 3,
				1 }));
	}
}
