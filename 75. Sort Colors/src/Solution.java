import java.util.Arrays;

public class Solution {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int[] cpArr = copy(nums);
		int idx0 = 0;
		int idx2 = nums.length - 1;

		for (int i : cpArr) {
			if (i == 0) {
				nums[idx0] = 0;
				idx0++;
			} else if (i == 2) {
				nums[idx2] = 2;
				idx2--;
			}
		}

		for (int i = idx0; i <= idx2; i++) {
			nums[i] = 1;
		}

	}

	private int[] copy(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = nums[i];
		}

		return res;
	}

	public static void main(String[] args) {
		int[] test = new int[] { 1, 2, 0, 1, 2 };
		new Solution().sortColors(test);
		System.out.println(Arrays.toString(test));
	}
}
