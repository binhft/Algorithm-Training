public class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		return sum(root, 1);
	}

	public int sum(TreeNode root, int pos) {
		if (root == null) {
			return 0;
		}

		int sum = 0;
		if (root.left != null) {
			sum += sum(root.left, 0);
		}
		if (root.right != null) {
			sum += sum(root.right, 1);
		}
		if (root.left == null && root.right == null) {
			if (pos == 0) {
				sum = root.val;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		TreeNode t3 = new TreeNode(13);
		TreeNode t9 = new TreeNode(9);
		TreeNode t15 = new TreeNode(15);
		TreeNode t20 = new TreeNode(20);
		TreeNode t7 = new TreeNode(7);

		t3.left = t9;
		t3.right = t20;
		t20.left = t15;
		t20.right = t7;

		System.out.println(new Solution().sumOfLeftLeaves(t3));
	}
}
