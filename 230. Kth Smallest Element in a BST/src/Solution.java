public class Solution {
	int res = 0;
	int count = 0;
	boolean isFound = false;
	public int kthSmallest(TreeNode root, int k) {
		visit(root, k);
		return res;
	}
	
	private void visit(TreeNode root, int k) {
		if (root == null || isFound) {
			return;
		}
		visit(root.left, k);
		
		count += 1;
		if (count == k) {
			isFound = true;
			res = root.val;
		}
		
		visit(root.right, k);
		
	}
	
	
}
