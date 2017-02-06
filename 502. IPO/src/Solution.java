import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		PriorityQueue<int[]> pqCap = new PriorityQueue<int[]>(
				(a, b) -> (a[0] - b[0]));
		PriorityQueue<int[]> pqPro = new PriorityQueue<int[]>(
				(a, b) -> (b[1] - a[1]));

		for (int i = 0; i < Profits.length; i++) {
			pqCap.add(new int[] { Capital[i], Profits[i] });
		}

		for (int i = 0; i < k; i++) {
			while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
				pqPro.add(pqCap.poll());
			}

			if (pqPro.isEmpty()) {
				break;
			}
			W += pqPro.poll()[1];
		}

		return W;

	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMaximizedCapital(2, 0, new int[] {
				1, 2, 3 }, new int[] { 0, 1, 1 }));
	}
}
