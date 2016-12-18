import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;

		int result = 0;
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum == target) {
					return sum;
				}
				int diff = Math.abs(sum - target);
				
				if (diff < min) {
					min = diff;
					result = sum;
				}
				
				if (sum <= target) {
					low ++;
				} else {
					high --;
				}
				
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int res = new Solution().threeSumClosest(new int[] { -1, 2, 1, -4}, 1);
		System.out.println(res);
	}
}
