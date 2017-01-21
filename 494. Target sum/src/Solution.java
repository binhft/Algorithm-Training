import java.util.List;

public class Solution {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums.length == 0) {
			return 0;
		}
		return check(nums, S, nums.length - 1);
	}

	private int check(int[] nums, int targetSum, int currentIndex) {
		if (currentIndex < 0) {
			if (targetSum == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		return check(nums, targetSum + nums[currentIndex], currentIndex - 1)
				+ check(nums, targetSum - nums[currentIndex], currentIndex - 1);

	}

	public static void main(String[] args) {
		System.out.println(new Solution().findTargetSumWays(new int[] {}, 1));
	}
}
