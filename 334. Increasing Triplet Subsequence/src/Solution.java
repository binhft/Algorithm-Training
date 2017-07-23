public class Solution {
	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num <= first) {
				first = num;
			} else if (num <= second) {
				second = num;
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().increasingTriplet(new int[] { 2,3,1,4 }));
	}
}
