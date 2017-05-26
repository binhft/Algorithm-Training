public class Solution {
	public int removeElement(int[] nums, int val) {
		int count = 0;
		int idx = 0;
		for (int num : nums) {
			if (num != val) {
				nums[idx] = num;
				count++;
				idx++;
			}

		}
		return count;
	}

	public static void main(String[] args) {
		int[] testArr = new int[] { 3, 2, 2, 3, 4 };
		System.out.println(new Solution().removeElement(testArr, 2));
	}
}
