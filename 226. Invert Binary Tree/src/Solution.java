public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;

	}

	private static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.println(root.val);
		printTree(root.right);
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t9 = new TreeNode(9);

		t4.left = t2;
		t4.right = t7;

		t2.left = t1;
		t2.right = t3;

		t7.left = t6;
		t7.right = t9;
		
		
		TreeNode res = new Solution().	invertTree(t4);
		printTree(res);
		
	}
}
