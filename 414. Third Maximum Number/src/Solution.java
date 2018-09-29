import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	public int thirdMax(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int val : nums) {
			set.add(val);
		}
		if (set.size() == 1) {
			return set.iterator().next();
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			int val = iter.next();
			pq.offer(val);

			if (pq.size() > 3) {
				pq.poll();
			}
		}
		if (pq.size() < 3) {
			int maxVal = pq.poll();
			while (!pq.isEmpty()) {
				maxVal = pq.poll();
			}
			return maxVal;
		}

		return pq.poll();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().thirdMax(new int[] { 2, 2, 3, 1 }));
		System.out.println(new Solution().thirdMax(new int[] { 1, 2 }));
		System.out.println(new Solution()
				.thirdMax(new int[] { 1, 2, 2, 5, 3, 5 }));
	}
}
