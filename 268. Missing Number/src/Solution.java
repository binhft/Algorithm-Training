public class Solution {
	public int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums.length;
		long correctSum = (long) (max * (max + 1) * 0.5);

		long realSum = 0;
		for (int num : nums) {
			realSum += num;
		}

		return (int) (correctSum - realSum);
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.missingNumber(new int[] { 0, 1 }));
	}
}
