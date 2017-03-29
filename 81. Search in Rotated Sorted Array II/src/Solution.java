public class Solution {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int len = nums.length;
		int start = 0;
		int end = len - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			}

			if (nums[mid] > nums[end]) {
				if (nums[mid] > target && nums[start] <= target) {
					end = mid;
				} else {
					start = mid + 1;
				}
			} else if (nums[mid] < nums[end]) {
				if (nums[mid] < target && nums[end] >= target) {
					start = mid + 1;
				} else {
					end = mid;
				}
			} else {
				end--;
			}
		}

		return nums[start] == target;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().search(new int[] { 6, 7, 1, 2, 3, 4,
				5 }, 1));
	}
}
