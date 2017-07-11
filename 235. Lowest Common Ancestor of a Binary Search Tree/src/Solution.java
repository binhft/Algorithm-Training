public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}

		int max = Math.max(p.val, q.val);
		int min = Math.min(p.val, q.val);

		while (root != null) {
			if (root.val > max) {
				root = root.left;
			} else if (root.val < min) {
				root = root.right;
			} else {
				return root;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode t6 = new TreeNode(6);
		TreeNode t2 = new TreeNode(2);
		TreeNode t8 = new TreeNode(8);
		TreeNode t0 = new TreeNode(0);
		TreeNode t4 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t7 = new TreeNode(7);
		TreeNode t9 = new TreeNode(9);
		t6.left = t2;
		t6.right = t8;
		
		t2.left = t0;
		t2.right = t4;
		t4.left = t3;
		t4.right = t5;
		
		t8.left = t7;
		t8.right = t9;
		
		TreeNode res = new Solution().lowestCommonAncestor(t6, t2, t4);
		if (res != null) {
			System.out.println(res.val);
		} else {
			System.out.println("null");
		}
	}
}
