import java.util.Arrays;

public class Solution {
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);

		int[] res = new int[target + 1];
		for (int i = 0; i < target + 1; i++) {
			for (int num : nums) {
				if (num > i) {
					break;
				} else if (num == i) {
					res[i] += 1;
				} else {
					res[i] += res[i - num];
				}
			}
		}
		return res[target];
	}

	public static void main(String[] args) {
		int[] candicates = new int[] { 1, 2, 3 };
		int res = new Solution().combinationSum4(candicates, 32);
		System.out.println(res);
		// for (List<Integer> list : res) {
		// System.out.println(list);
		// }
	}
}
