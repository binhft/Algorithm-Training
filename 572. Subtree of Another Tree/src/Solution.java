public class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		String sSer = travel(s, true);
		String tSer = travel(t, true);
		
		if (sSer.contains(tSer)) {
			return true;
		}
		
		return false;
	}

	private String travel(TreeNode root, boolean left) {
		if (root == null) {
			if (left) {
				return "lnull";
			} else {
				return "rnull";
			}
		}
		return "#" + root.val + " " + travel(root.left, true) + " " + travel(root.right, true);
	}
}
