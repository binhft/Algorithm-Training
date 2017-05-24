import java.util.Arrays;

public class Solution {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int idx = 0;

		for (int num : nums) {
			if (num != 0) {
				nums[idx] = num;
				idx++;
			}
		}

		while (idx < nums.length) {
			nums[idx] = 0;
			idx++;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,3,0,4,0,5,0};
		new Solution().moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
