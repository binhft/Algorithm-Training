import java.util.Stack;

public class Solution {
	// stack solution
	// public int largestRectangleArea(int[] heights) {
	// int res = 0;
	// if (heights.length == 0) {
	// return res;
	// }
	//
	// Stack<Integer> stack = new Stack<Integer>();
	// for (int i = 0; i <= heights.length; i++) {
	// int h = i < heights.length ? heights[i] : 0;
	// if (stack.isEmpty() || h >= heights[stack.peek()]) {
	// stack.push(i);
	// } else {
	// int tp = stack.pop();
	// res = Math.max(res, heights[tp]
	// * (stack.isEmpty() ? i : (i - 1 - stack.peek())));
	// i--;
	// }
	// }
	// return res;
	// }

	// dp solution
	public int largestRectangleArea(int[] heights) {
		int res = 0;
		if (heights.length == 0) {
			return res;
		}

		int[] left = new int[heights.length];
		int[] right = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			right[i] = heights.length;
			int p = i - 1;
			while (p >= 0 && heights[i] <= heights[p]) {
				// System.out.println("loop 1" + i);
				p = left[p] - 1;
			}
			left[i] = p + 1;
		}

		for (int i = heights.length - 2; i >= 0; i--) {
			int p = i + 1;
			while (p < heights.length && heights[i] <= heights[p]) {
				// System.out.println("loop 2 " + i);
				p = right[p];
			}
			right[i] = p;
		}

		for (int i = 0; i < heights.length; i++) {
//			System.out.println("i = " + i + " res = " + left[i] + " " + right[i]);
			res = Math.max(res, heights[i] * (right[i] - left[i]));
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().largestRectangleArea(new int[] { 2,
				1, 2 }));
	}
}
