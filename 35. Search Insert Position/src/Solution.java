public class Solution {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low)/2;
			int val = nums[mid];
			if (val == target) {
				return mid;
			} else if (val > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().searchInsert(new int[] {1}, 2));
	}
}
