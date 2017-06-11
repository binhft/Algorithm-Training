import java.util.Arrays;

public class Solution {
	public int triangleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		Arrays.sort(nums);

		int count = 0;

		for (int i = 0; i < n - 2; ++i) {
			int k = i + 2;

			for (int j = i + 1; j < n; ++j) {

				while (k < n && nums[i] + nums[j] > nums[k]) {
					++k;
				}
				if (j < k) {
					count += k - j - 1;
				}
				
//				System.out.println("Count = " + count + " k=" + k);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.triangleNumber(new int[] { 2, 2, 3, 4 }));
		System.out
				.println(new Solution().triangleNumber(new int[] { 0, 0, 0 }));
	}
}
