import java.util.Arrays;

public class Solution {
	public int[] findErrorNums(int[] nums) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0) {
			return res;
		}

		int[] check = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			if (check[nums[i]] == 0) {
				check[nums[i]] = 1;
			} else if (check[nums[i]] == 1) {
				check[nums[i]] = 2;
				res[0] = nums[i];
			}
		}

		for (int i = 1; i < check.length; i++) {
			if (check[i] == 0) {
				res[1] = i;
				break;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution()
				.findErrorNums(new int[] { 1, 2, 2, 4 })));
	}
}
