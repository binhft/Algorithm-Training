import java.util.PriorityQueue;

public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		for (int j = 0; j < n; j++) {
			pq.offer(new Tuple(0, j, matrix[0][j]));
		}

		for (int i = 0; i < k - 1; i++) {
			Tuple tmp = pq.poll();
			if (tmp.x == n - 1) {
				continue;
			}
			pq.offer(new Tuple(tmp.x + 1, tmp.y, matrix[tmp.x + 1][tmp.y]));
		}
		
		return pq.poll().val;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 },
				{ 12, 13, 15 } };
		System.out.println(new Solution().kthSmallest(matrix, 3));
	}
}

class Tuple implements Comparable<Tuple> {
	int x, y, val;

	public Tuple(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Tuple o) {
		return this.val - o.val;
	}
}
