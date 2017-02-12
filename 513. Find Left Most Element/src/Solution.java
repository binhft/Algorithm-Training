public class Solution {
	class TreeNodeHelper {
		TreeNode node;
		int height;

		public TreeNodeHelper(TreeNode node, int height) {
			super();
			this.node = node;
			this.height = height;
		}

	}

	private TreeNodeHelper helper(TreeNode node, int height) {
		TreeNodeHelper leftNodeHelper = null;
		TreeNodeHelper rightNodeHelper = null;

		if (node.left != null) {
			leftNodeHelper = helper(node.left, height + 1);
		} else {
			leftNodeHelper = new TreeNodeHelper(node, height);
		}

		if (node.right != null) {
//			System.out.println("Not null");
			rightNodeHelper = helper(node.right, height + 1);
		}

		if (rightNodeHelper != null) {
			if (rightNodeHelper.height > leftNodeHelper.height) {
				leftNodeHelper = rightNodeHelper;
			}
		}
//		System.out.println(node.val + " " + leftNodeHelper.node.val + " " + leftNodeHelper.height);
		return leftNodeHelper;
	}

	public int findLeftMostNode(TreeNode root) {
		TreeNodeHelper nodeHelper = helper(root, 1);
		
		return nodeHelper.node.val;
	}
	
	public static void main(String[] args) {
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		
		t1.left = t2;
		t1.right = t3;
		
		t2.left = t4;
		t3.left = t5;
		t3.right = t6;
		t5.left = t7;
		
		
		
		System.out.println(new Solution().findLeftMostNode(t1));
	}
}
