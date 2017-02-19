public class Solution {
	public int maxArea(int[] height) {
		int max = 0;
		if (height == null || height.length == 0) {
			return 0;
		}
		int l = 0;
		int r = height.length - 1;

		while (l < r) {
//			System.out.println(l + " " + r);
			max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
			int hiMin = height[l];
			int hiMax = height[r];
			if (height[l] < height[r]) {
				while (l < r && height[l] <= hiMin) {
//					System.out.println("1");
					l++;
				}

			} else {
				while (r > l && height[r] <= hiMax) {
//					System.out.println("2");
					r--;
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.maxArea(new int[] { 6, 5, 4, 3, 2, 1 }));
	}
}
