public class Solution {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else { // nums[mid] = nums[end]
				if (nums[start] == nums[mid]) {
					start++;
					end--;
				} else {
					end = mid;
				}
			}
		}

		return nums[start];

	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMin(new int[] { 4, 5, 6, 7, 0, 1, 1,
				2 }));
	}
}
