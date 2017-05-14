import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> arr = new ArrayList<Integer>();
		visit(arr, root);
		return arr;
	}
	
	private void visit(List<Integer> list, TreeNode currentNode) {
		if (currentNode == null) {
			return;
		}
		
		visit(list, currentNode.left);
		list.add(currentNode.val);
		visit(list, currentNode.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.right = n2;
		n2.left = n3;
		
		System.out.println(new Solution().inorderTraversal(n1));
	}
}
