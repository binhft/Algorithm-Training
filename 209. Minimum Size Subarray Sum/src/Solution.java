import java.util.Arrays;

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] sum = new int[nums.length];
		int total = 0;

		for (int i = 0; i < nums.length; i++) {
			sum[i] = total + nums[i];
			total = sum[i];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int low = i;
			int high = nums.length - 1;

			while (low < high) {
				int mid = low + (high - low) / 2;
				int curr = sum[mid] - (i > 0 ? sum[i - 1] : 0);
				if (curr < s) {
					low = mid + 1;
				} else if (curr >= s) {
					high = mid;
				}
			}

			int val = sum[low] - (i > 0 ? sum[i - 1] : 0);
			if (val >= s) {
//				System.out.println("i=" + i + " low=" + low);
				for (int j = i; j <= low; j++) {
//					System.out.print(nums[j] + ",");
				}
				min = Math.min(min, low - i + 1);
			}
		}
		if (min == Integer.MAX_VALUE) {
			return 0;
		}
		return min;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 2, 3, 1, 2, 4, 3 };
		System.out.println(new Solution().minSubArrayLen(4, input));
	}

}
