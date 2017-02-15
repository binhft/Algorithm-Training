import java.util.Arrays;

public class Solution {
	public String[] findRelativeRanks(int[] nums) {
		int[][] rankArr = new int[nums.length][2];
		
		for (int i = 0; i < nums.length; i++) {
			rankArr[i][0] = nums[i];
			rankArr[i][1] = i;
		}
		
		Arrays.sort(rankArr, (a, b) -> (b[0] - a[0]));
		String[] result = new String[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				result[rankArr[i][1]] = "Gold Medal";
			} else if (i == 1) {
				result[rankArr[i][1]] = "Silver Medal";
			} else if (i == 2) {
				result[rankArr[i][1]] = "Bronze Medal";
			} else {
				result[rankArr[i][1]] = (i + 1) + "";
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] res = new Solution().findRelativeRanks(new int[] {5, 4, 3, 2, 1});
		System.out.println(Arrays.toString(res));
	}
}
