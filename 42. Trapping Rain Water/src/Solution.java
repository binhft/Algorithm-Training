
public class Solution {
	public int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int len = height.length;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];

		int left = 0;
		int right = 0;
		for (int i = 0; i < len; i++) {
			leftMax[i] = Math.max(height[i], left);
			left = leftMax[i];
		}
		for (int i = len - 1; i >= 0; i--) {
			rightMax[i] = Math.max(height[i], right);
			right = rightMax[i];
		}

		int res = 0;
		for (int i = 0; i < len; i++) {
			res += Math.min(rightMax[i], leftMax[i]) - height[i];
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().trap(new int[] { 0, 1, 0, 2, 1, 0, 1,
				3, 2, 1, 2, 1 }));
	}
}
