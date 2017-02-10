import java.util.Arrays;

public class Solution {
	public int[] singleNumber(int[] nums) {
		int[] res = new int[] { 0, 0 };
		int diff = 0;
		for (int i = 0; i < nums.length; i++) {
			diff ^= nums[i];
		}
		
		diff &= -diff;
		
		for (int num: nums) {
			if ((num & diff) == 0) {
				res[0] = res[0] ^ num;
			} else {
				res[1] = res[1] ^ num;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] res = new Solution().singleNumber(new int[]{1,2,3,3,2,1,4,5});
		System.out.println(Arrays.toString(res));
	}
}
