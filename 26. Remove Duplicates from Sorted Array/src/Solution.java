public class Solution {
	public int removeDuplicates(int[] nums) {
		int count = 0;

		if (nums == null || nums.length == 0) {
			return count;
		}

		int idx = 1;
		int last = nums[0];
		count += 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != last) {
				nums[idx] = nums[i];
				last = nums[i];
				idx++;
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().removeDuplicates(new int[] { 0, 1, 2,
				2, 3, 4 }));
	}
}
