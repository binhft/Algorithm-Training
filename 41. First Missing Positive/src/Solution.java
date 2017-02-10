public class Solution {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		
		for (int i = 0; i < len; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return len + 1;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().firstMissingPositive(new int[] { 1,
				-1, 2, 3, -2 }));
	}
}
