import java.util.Stack;

public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		int res = 0;
		int[] heights = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					heights[j] += 1;
				} else {
					heights[j] = 0;
				}
			}

			res = Math.max(res, getLargestArea(heights));
		}

		return res;
	}

	private int getLargestArea(int[] heights) {
		int n = heights.length;
		if (n == 0) {
			return 0;
		}

		int res = 0;

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i <= n; i++) {
			int h = (i == n) ? 0 : heights[i];
			if (stack.isEmpty() || h >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				int tp = stack.pop();
				res = Math.max(res, heights[tp]
						* (stack.isEmpty() ? i : (i - 1 - stack.peek())));
				i--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// char[][] input = new char[][] { { '1', '0', '1', '0', '0' },
		// { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
		// { '1', '0', '0', '1', '0' } };
		char[][] input = new char[][] { { '1', '1' } };
		System.out.println(new Solution().maximalRectangle(input));
	}
}
