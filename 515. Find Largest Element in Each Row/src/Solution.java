import java.util.Arrays;

public class Solution {

	public int[] findValueMostElement(TreeNode root) {

		int[] tempRes = new int[1000];
		for (int i = 0; i < 1000; i++) {
			tempRes[i] = Integer.MIN_VALUE;
		}
		int height = travel(root, 0, tempRes);
		// System.out.println(height);

		return Arrays.copyOfRange(tempRes, 0, height);

	}

	private int travel(TreeNode node, int height, int[] treeRes) {
		int currentHeight = 1;
		if (node != null) {
			treeRes[height] = Math.max(treeRes[height], node.val);
		} else {
			return 0;
		}
		if (node.left != null) {
			int leftHeight = travel(node.left, height + 1, treeRes);
			currentHeight = Math.max(currentHeight, leftHeight + 1);
		}
		if (node.right != null) {
			int rightHeight = travel(node.right, height + 1, treeRes);
			currentHeight = Math.max(rightHeight + 1, currentHeight);
		}

		return currentHeight;

	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t3_1 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t9 = new TreeNode(9);

		// t1.left = t2;
		// t1.right = t3;
		//
		// t2.left = t5;
		// t2.right = t3_1;
		//
		// t3.right = t9;
		t1.right = t2;

		int[] res = new Solution().findValueMostElement(t1);

		System.out.println(Arrays.toString(res));
	}
}
