import java.util.Stack;

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		return check(root, 0, sum);
	}

	private boolean check(TreeNode currentNode, int currentSum, int totalSum) {
		if (currentNode == null) {
			return false;
		}
		int val = currentNode.val + currentSum;
		// System.out.println(val);
		if (val == totalSum && currentNode.left == null
				&& currentNode.right == null) {
			return true;
		} else {
			boolean val1 = false;
			boolean val2 = false;
			if (currentNode.left != null) {
				val1 = check(currentNode.left, val, totalSum);
			}
			if (currentNode.right != null) {
				val2 = check(currentNode.right, val, totalSum);
			}
			return val1 || val2;
		}
	}

	public static void main(String[] args) {
		int[] val = new int[] { -3, 4, -2, 7, 2, 8, 13, 4, 1 };
		TreeNode[] treeNode = new TreeNode[val.length];

		for (int i = 0; i < val.length; i++) {
			treeNode[i] = new TreeNode(val[i]);
		}

		// treeNode[0].left = treeNode[1];
		treeNode[0].right = treeNode[2];

		System.out.println(new Solution().hasPathSum(treeNode[0], -5));
	}
}
