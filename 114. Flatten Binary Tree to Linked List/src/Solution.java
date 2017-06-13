import java.util.Stack;

public class Solution {
	public void flatten(TreeNode root) {
		// if (root == null) {
		// return;
		// }
		// Stack<TreeNode> stack = new Stack<TreeNode>();
		// stack.add(root);
		//
		// while (!stack.isEmpty()) {
		// TreeNode curr = stack.pop();
		// System.out.println(curr.val);
		// if (curr.left != null) {
		// stack.add(curr.left);
		// }
		// if (curr.right != null) {
		// stack.add(curr.right);
		// }
		// }
		travel(root);
	}

	private TreeNode travel(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode left = travel(root.left);
		TreeNode right = travel(root.right);
		// System.out.println(root.val + " left=" + (left != null ? left.val :
		// "") + " right= " + (right != null ? right.val : ""));
		// if (left != null) {
		// left.right = root.right;
		// root.right = root.left;
		// }
		if (left != null) {
			TreeNode leftFake = left;
			while (leftFake != null && leftFake.right != null) {
				leftFake = leftFake.right;
			}
			if (leftFake != null) {
				leftFake.right = right;
			}
			root.right = left;
		}
		root.left = null;
		return root;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);

		// t1.left = t2;
		// t2.left = t3;
		// t2.right = t4;
		//
		// t1.right = t5;
		// t5.right = t6;
		t1.right = t2;
//		t2.left = t3;

		new Solution().flatten(t1);
		System.out.println("");
		while (t1 != null) {
			System.out.println(t1.val);
			t1 = t1.right;
		}

		// while (t2 != null) {
		// System.out.println(t2.val);
		// t2 = t2.right;
		// }
	}
}
