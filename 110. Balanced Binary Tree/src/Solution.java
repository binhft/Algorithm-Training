public class Solution {
	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = height(node.left);
		if (leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = height(node.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}
}
