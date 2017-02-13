import java.util.Arrays;
import java.util.List;

public class Solution {
	class Node {
		int val;
		int count = 1;
		int less = 0;
		Node left, right;

		public Node(int val) {
			super();
			this.val = val;
		}

	}

	private Node build(Node node, int val, Integer[] res, int i, int preSum) {
		if (node == null) {
			node = new Node(val);
			res[i] = preSum;
		} else if (node.val == val) {
			node.count += 1;
			res[i] = preSum + node.less;
		} else if (node.val > val) {
			node.less++;
			node.left = build(node.left, val, res, i, preSum);
		} else {

			node.right = build(node.right, val, res, i, preSum + node.less + node.count);
		}
		return node;
	}

	public List<Integer> countSmaller(int[] nums) {
		Integer[] res = new Integer[nums.length];
		Node root = null;
		for (int i = nums.length - 1; i >= 0 ; i--) {
			root = build(root, nums[i], res, i, 0);
		}
		return Arrays.asList(res);

	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.countSmaller(new int[] { 5, 2, 6, 1 }));
	}
}
