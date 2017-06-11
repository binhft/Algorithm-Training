public class Solution {
	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		branchMax(root);
		return max - 1;

	}

	private int branchMax(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMax = branchMax(root.left);
		int rightMax = branchMax(root.right);

		max = Math.max(max, leftMax + rightMax + 1);
		return Math.max(leftMax + 1, rightMax + 1);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(1);
		TreeNode t6 = new TreeNode(1);

		t1.left = t2;
//		t1.right = t3;
//		t2.left = t4;
//		t2.right = t5;
		System.out.println(new Solution().diameterOfBinaryTree(t1));
	}
}
