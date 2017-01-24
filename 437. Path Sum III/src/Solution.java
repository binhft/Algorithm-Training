import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	// recursion
//	public int pathSum(TreeNode root, int sum) {
//		if (root == null) {
//			return 0;
//		}
//		return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//	}
//
//	private int helper(TreeNode root, int sum) {
//		int res = 0;
//		if (root == null) {
//			return 0;
//		}
//		if (sum == root.val) {
//			res += 1;
//		}
//		if (root.left != null) {
//			res += helper(root.left, sum - root.val);
//		}
//		if (root.right != null) {
//			res += helper(root.right, sum - root.val);
//		}
//		return res;
//	}
	
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		return helper(root, sum, 0, map);
	}

	private int helper(TreeNode root, int target, int sum, HashMap<Integer, Integer> preSum) {
		int res = 0;
		if (root == null) {
			return res;
		}
		
		sum += root.val;
		res += preSum.getOrDefault(sum - target, 0);
		preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		
		res += helper(root.left, target, sum, preSum) + helper(root.right, target, sum, preSum);
		preSum.put(sum, preSum.get(sum) - 1);
		return res;
	}
	
	public static void main(String[] args) {

		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n55 = new TreeNode(5);
		TreeNode n8 = new TreeNode(8);
		TreeNode n11 = new TreeNode(11);
		TreeNode n13 = new TreeNode(13);
		// n5.left = n4;
		// n4.left = n55;
		// n5.right = n8;
		// n4.left = n11;
		// n8.left = n13;
		n4.left = n5;
		n5.left = n55;

		System.out.println(new Solution().pathSum(n4, 9));

	}

}
