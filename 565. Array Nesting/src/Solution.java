import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int arrayNesting(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = 0;
		boolean[] visited = new boolean[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				Set<Integer> set = new HashSet<Integer>();
				int tmp = i;
				while (!set.contains(tmp) && !visited[tmp]) {
					visited[tmp] = true;
					set.add(tmp);
					tmp = nums[tmp];
				}

				if (set.size() > max) {
					max = set.size();
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().arrayNesting(new int[] { 5, 4, 0, 3,
				1, 6, 2 }));
	}
}
