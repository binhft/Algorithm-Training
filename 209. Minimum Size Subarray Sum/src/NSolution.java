public class NSolution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
//				System.out.println("left= " + left + " i=" + i);
				ans = Math.min(ans, i - left + 1);
				sum -= nums[left];
				left++;
			}

		}

		return ans != Integer.MAX_VALUE ? ans : 0;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 2, 3, 1, 2, 4, 3 };
		System.out.println(new NSolution().minSubArrayLen(7, input));
	}
}
