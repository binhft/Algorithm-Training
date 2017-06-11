public class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		TreeNode left = mergeTrees(t1.left, t2.left);
		TreeNode right = mergeTrees(t1.right, t2.right);

		TreeNode root = new TreeNode(t1.val + t2.val);
		root.left = left;
		root.right = right;

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
		TreeNode t5 = new TreeNode(5);
		
		t1.left = t3;
		t1.right = t2;
		t3.left = t5;
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		
		n2.left = n1;
		n2.right = n3;
		n1.right = n4;
		n3.right = n7;
		
		TreeNode merge = new Solution().mergeTrees(t1, null);
		printTree(merge);
		
		
	}
}
