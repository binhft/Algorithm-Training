import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		
		if (root == null) {
			return res;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == 0) {
					res.add(node.val);
				}
				
				if (node.right != null) {
					queue.add(node.right);
				}
				
				if (node.left != null) {
					queue.add(node.left);
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n1.right = n2;
		n1.left = n3;
		System.out.println(new Solution().rightSideView(n1));
		
	}
	
}
