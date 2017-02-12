public class Solution {
	class Node {
		int val, less = 0, count = 1;
		Node left, right;

		public Node(int v) {
			this.val = v;
		}
	}

	private void search(int[] cnt, Node node, double target) {
		if (node == null)
			return;
		else if (target == node.val)
			cnt[0] += node.less;
		else if (target < node.val)
			search(cnt, node.left, target);
		else {
			cnt[0] += node.less + node.count;
			search(cnt, node.right, target);
		}
	}

	private Node build(int val, Node n) {
		if (n == null) {
			return new Node(val);
		}

		if (val == n.val) {
			n.count += 1;
		} else if (val > n.val) {
			n.right = build(val, n.right);
		} else {
			n.less += 1;
			n.left = build(val, n.left);
		}
		return n;
	}

	public int reversePairs(int[] nums) {
		Node root = null;
		int[] cnt = new int[1];
		// for (int i = 0; i < nums.length; i++) {
		for (int i = nums.length - 1; i >= 0; i--) {
			search(cnt, root, nums[i] / 2.0);
			root = build(nums[i], root);
		}

		return cnt[0];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reversePairs(new int[] { 2, 4, 3, 5,
				1 }));
		System.out.println(new Solution().reversePairs(new int[] { 1, 3, 2, 3,
				1 }));
	}
}
