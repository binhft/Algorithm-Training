import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) {
			return 0;
		}
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int compValue = nums[i] + k;
			map.put(compValue, map.getOrDefault(compValue, 0) + 1);
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				continue;
			}
			set.add(nums[i]);
			if (k == 0) {
				if (map.getOrDefault(nums[i], 0) >= 2) {
					res += 1;
				}
			} else {
				if (map.containsKey(nums[i])) {
					res += 1;
				}
			}

		}
		return res;

	}

	public static void main(String[] args) {
		System.out.println(new Solution().findPairs(
				new int[] { 1, 3, 1, 5, 4 }, 0));
	}
}
