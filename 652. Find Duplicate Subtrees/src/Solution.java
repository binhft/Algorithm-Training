import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if (root == null) {
			return new ArrayList<TreeNode>();
		}
		List<TreeNode> res = new ArrayList<TreeNode>();
		HashMap<String, HashMap<String, ArrayList<TreeNode>>> map = new HashMap<String, HashMap<String, ArrayList<TreeNode>>>();
		travel(root, map);

		for (String innerKey : map.keySet()) {
			HashMap<String, ArrayList<TreeNode>> innerMap = map.get(innerKey);
			for (String iKey : innerMap.keySet()) {
				ArrayList<TreeNode> arr = innerMap.get(iKey);
				for (TreeNode node : arr) {
					System.out.print(node.val);
				}
				System.out.println("");
				if (arr.size() > 1) {
					res.add(arr.get(0));
				}
			}
		}
		return res;
	}

	public String[] travel(TreeNode root,
			HashMap<String, HashMap<String, ArrayList<TreeNode>>> map) {
		if (root == null) {
			return new String[2];
		}
		String[] left = travel(root.left, map);
		String[] right = travel(root.right, map);
		String[] res = new String[2];

		res[0] = root.val + left[0] + right[0];
		res[1] = left[1] + root.val + right[1];

		HashMap<String, ArrayList<TreeNode>> innerMap;

		if (map.containsKey(res[0])) {
			innerMap = map.get(res[0]);
		} else {
			innerMap = new HashMap<String, ArrayList<TreeNode>>();
			map.put(res[0], innerMap);
		}
		ArrayList<TreeNode> list;

		if (innerMap.containsKey(res[1])) {
			list = innerMap.get(res[1]);
		} else {
			list = new ArrayList<TreeNode>();
			innerMap.put(res[1], list);
		}
		list.add(root);

		return res;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t21 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t41 = new TreeNode(4);
		TreeNode t42 = new TreeNode(4);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.left = t21;
		t3.right = t41;
		t21.left = t42;
		
//		t1.left = t2;
//		t1.right = t21;

		List<TreeNode> res = new Solution().findDuplicateSubtrees(t1);
		for (TreeNode node: res) {
			System.out.print(node.val);
		}

	}
}
