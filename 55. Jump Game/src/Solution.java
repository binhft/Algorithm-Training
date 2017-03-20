import java.util.Stack;

public class Solution {
	public boolean canJump(int[] nums) {
		int lastPost = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPost) {
				lastPost = i;
			}
		}
		return lastPost == 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().canJump(new int[] { 3, 2, 1, 0, 4 }));
	}
}
