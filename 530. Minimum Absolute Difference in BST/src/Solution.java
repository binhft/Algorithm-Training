public class Solution {

	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return min;
		}

		getMinimumDifference(root.left);
		
		if (prev != null) {
			min = Math.min(root.val - prev, min);
		}
		
		prev = root.val;

		getMinimumDifference(root.right);

		return min;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);

		t1.right = t3;
		t3.left = t2;

		System.out.println(new Solution().getMinimumDifference(t1));
	}
}
