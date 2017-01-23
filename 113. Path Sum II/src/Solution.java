import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null) {
			List<Integer> seed = new ArrayList<Integer>();
			helper(res, seed, sum, 0, root);
		}
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> currentList,
			int target, int currentSum, TreeNode currentNode) {
		if (currentNode.left == null && currentNode.right == null) {
			if (currentSum + currentNode.val == target) {
				currentList.add(currentNode.val);
				res.add(new ArrayList<Integer>(currentList));
				return;
			}
		}

		if (currentNode.left != null) {

			List<Integer> nextList = new ArrayList<Integer>(currentList);
			nextList.add(currentNode.val);
			helper(res, nextList, target, currentSum + currentNode.val,
					currentNode.left);
		}

		if (currentNode.right != null) {
			List<Integer> nextList = new ArrayList<Integer>(currentList);
			nextList.add(currentNode.val);
			helper(res, nextList, target, currentSum
					+ currentNode.val, currentNode.right);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n11 = new TreeNode(11);
		TreeNode n13 = new TreeNode(13);
		n5.left = n4;
		n5.right = n8;
		// n4.left = n11;
		// n8.left = n13;

		res = new Solution().pathSum(null, 9);

		for (List<Integer> listItem : res) {
			System.out.println(listItem);
		}
	}
}
