public class Solution {
	public double findMaxAverage(int[] nums, int k) {
		double left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] < left)
				left = nums[i];
			if (nums[i] > right)
				right = nums[i];
		}

		while (right - left >= 1e-6) {
			double mid = (left + right) / 2.0;

			if (is_valid(nums, mid, k)) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return left;

	}

	private boolean is_valid(int nums[], double mid, int k) {
		int n = nums.length;
		double min = 0;
		double[] sum = new double[n + 1];
		sum[0] = 0;
		for (int i = 1; i <= n; ++i) {
			sum[i] = sum[i - 1] + nums[i - 1] - mid;
			if (i >= k && sum[i] - min >= 0) {
				return true;
			}
			if (i >= k)
				min = Math.min(min, sum[i - k + 1]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
	}

}
