public class Solution {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lHeight = height(root.left);
		int rHeight = height(root.right);

		if (lHeight == rHeight) {
			return (1 << lHeight) + countNodes(root.right);
		} else {
			return (1 << rHeight) + countNodes(root.left);
		}
	}

	private int height(TreeNode root) {
		int res = 0;
		while (root != null) {
			root = root.left;
			res += 1;
		}
		return res;
	}

	public static void main(String[] args) {
		// System.out.println(1 << 2);
	}
}
