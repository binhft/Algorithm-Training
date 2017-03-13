import java.util.Arrays;

public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return buildTree(nums, 0, nums.length - 1);
	}

	private TreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, start, mid - 1);
		root.right = buildTree(nums, mid + 1, end);

		return root;
	}

	public static void main(String[] args) {
		TreeNode node = new Solution().sortedArrayToBST(new int[] { 1, 2, 3, 4,
				5 });
		System.out.println(node.val);
		System.out.println(node.left.val);
		System.out.println(node.right.val);
	}
}
