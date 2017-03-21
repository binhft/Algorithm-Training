public class Solution {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < nums[high]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return nums[low];

	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMin(new int[] { 4, 5, 6, 7, 0, 1,
				2 }));
	}
}
