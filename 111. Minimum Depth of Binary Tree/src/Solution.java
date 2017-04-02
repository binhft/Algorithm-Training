import java.util.Stack;

public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> val = new Stack<Integer>();
		stack.push(root);
		val.push(1);
		int min = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int value = val.pop();

			if (node.left != null) {
				stack.push(node.left);
				val.push(value + 1);
			}
			if (node.right != null) {
				stack.push(node.right);
				val.push(value + 1);
			}

			if (node.left == null && node.right == null) {
				min = Math.min(value, min);
			}

		}

		return min;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n1.right = n5;
		
		System.out.println(new Solution().minDepth(n1));
		
	}
}
