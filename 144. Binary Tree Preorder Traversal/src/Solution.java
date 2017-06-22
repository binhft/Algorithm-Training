import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
	// Solution 1
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			res.add(node.val);

			if (node.right != null) {
				queue.addFirst(node.right);
			}

			if (node.left != null) {
				queue.addFirst(node.left);
			}

		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t2.left = t3;
		t2.right = t4;
		t1.right = t5;
		t5.left = t6;
		t5.right = t7;

		System.out.println(new Solution().preorderTraversal(t1));
	}
}
