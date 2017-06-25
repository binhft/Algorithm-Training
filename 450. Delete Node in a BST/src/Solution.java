public class Solution {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			TreeNode minNode = findMin(root.right);
			root.val = minNode.val;
			root.right = deleteNode(root.right, root.val);

		}
		return root;
	}

	private TreeNode findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	private static void printTree(TreeNode node) {
		if (node == null) {
			return;
		}
		printTree(node.left);
		System.out.println(node.val);
		printTree(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode t2 = new TreeNode(2); 
		TreeNode t3 = new TreeNode(3); 
		TreeNode t4 = new TreeNode(4); 
		TreeNode t5 = new TreeNode(5); 
		TreeNode t6 = new TreeNode(6); 
		TreeNode t7 = new TreeNode(7); 
		
		t5.left = t3;
		t5.right = t6;
		t6.right = t7;
		t3.left = t2;
		t3.right = t4;
		System.out.println("Before");
		printTree(t5);
		TreeNode newTreeNode = new Solution().deleteNode(t5, 3);
		System.out.println("After");
		printTree(newTreeNode);
	}

}
