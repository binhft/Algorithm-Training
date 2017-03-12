import java.util.Stack;

public class Solution {
	public TreeNode str2tree(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int currentValue = 0;
		int sign = 1;
		boolean hasVal = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
//			System.out.println("Char " + c);
			if (c == '(') {
				if (hasVal) {
					stack.add(new TreeNode(sign * currentValue));
					sign = 1;
					currentValue = 0;
					hasVal = false;
				}

			} else if (c == ')') {
				if (hasVal) {
					stack.add(new TreeNode(sign * currentValue));
					sign = 1;
					currentValue = 0;
					hasVal = false;
				}

				TreeNode node = stack.pop();
				if (!stack.empty()) {
					TreeNode parentNode = stack.peek();
					if (parentNode.left == null) {
						parentNode.left = node;
					} else if (parentNode.right == null) {
						parentNode.right = node;
					}
				}
			} else if (c == '-') {
				sign = -1;
			} else {
				int digit = c - '0';
				currentValue = digit + currentValue * 10;
				hasVal = true;

			}
//			if (!stack.empty()) {
//				System.out.println("Top: " + stack.peek().val);
//			} else {
//				System.out.println("Empty");
//			}
		}
		if (hasVal) {
			stack.add(new TreeNode(sign * currentValue));
		}
		return stack.peek();

	}

	private void visitTree(TreeNode node) {
		if (node != null) {
			visitTree(node.left);
			String s = node.val + " ";
			if (node.left != null) {
				s += " left: " + node.left.val;
			}
			if (node.right != null) {
				s += " right: " + node.right.val;
			}
			System.out.println(s);
			visitTree(node.right);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = s.str2tree("51");
		s.visitTree(root);
	}
}
