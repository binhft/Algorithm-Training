import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root == null) {
			return res;
		}
		if (root.left != null) {
			List<String> left = binaryTreePaths(root.left);
			for (String item: left) {
				res.add(root.val + "->" + item);
			}
		}
		
		if (root.right != null) {
			List<String> right = binaryTreePaths(root.right);
			for (String item: right) {
				res.add(root.val +  "->" + item);
			}
		}
		
		if (root.left == null && root.right == null) {
			res.add(""+ root.val);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.right = n5;
		
		List<String> res = new Solution().binaryTreePaths(n5);
		System.out.println(res);
	}
}
