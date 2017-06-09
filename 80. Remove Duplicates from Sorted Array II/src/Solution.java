import java.util.Arrays;

public class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i < 2 || nums[i] > nums[idx - 2]) {
				nums[idx] = nums[i];
				idx++;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {1,1,1,2,2,3};
		System.out.println(new Solution().removeDuplicates(input));
		System.out.println(Arrays.toString(input));
	}
}
