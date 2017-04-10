import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode>[] list = new List[n + 1];
		list[0] = new ArrayList<TreeNode>();
		if (n == 0) {
			return list[0];
		}
		list[0].add(null);

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<TreeNode>();
			for (int j = 0; j < i; j++) {
				for (TreeNode nodeL : list[j]) {
					for (TreeNode nodeR : list[i - j - 1]) {
						TreeNode node = new TreeNode(j + 1);
						node.left = nodeL;
						node.right = clone(nodeR, j + 1);
						list[i].add(node);
					}
				}
			}
		}
		return list[n];
	}

	private TreeNode clone(TreeNode node, int offset) {
		if (node == null) {
			return null;
		}

		TreeNode newNode = new TreeNode(node.val + offset);
		newNode.left = clone(node.left, offset);
		newNode.right = clone(node.right, offset);

		return newNode;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().generateTrees(3).size());
	}
}
