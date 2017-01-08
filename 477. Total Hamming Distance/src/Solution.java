public class Solution {
	public int totalHammingDistance(int[] nums) {
		int total = 0;
		int n = 32;
		int[] countOne = new int[n];
		int numElement = nums.length;
		
		for (int i = 0; i < numElement; i++) {
			for (int j = 0; j < n; j++) {
				countOne[j] += (nums[i] >> j) & 1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			total += countOne[i] * (numElement - countOne[i]);
		}
		return total;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().totalHammingDistance(new int[]{4, 14, 2}));
	}
}
