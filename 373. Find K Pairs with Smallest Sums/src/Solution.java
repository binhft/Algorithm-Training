import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<int[]>();
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1]
				- b[0] - b[1]);
		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return res;
		}

		for (int i = 0; i < k && i < nums1.length; i++) {
			queue.offer(new int[] { nums1[i], nums2[0], 0 });
		}

		while (k-- > 0 && !queue.isEmpty()) {
			int[] curr = queue.poll();
			res.add(new int[] { curr[0], curr[1] });
			if (curr[2] == nums2.length - 1) {
				continue;
			}

			queue.offer(new int[] { curr[0], nums2[curr[2] + 1], curr[2] + 1 });
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {};
		int[] nums2 = new int[] {};

		List<int[]> res = new Solution().kSmallestPairs(nums1, nums2, 5);
		for (int[] item : res) {
			System.out.println(Arrays.toString(item));
		}
	}
}
