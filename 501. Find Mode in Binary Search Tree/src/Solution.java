import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int[] findMode(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		visit(list, root);

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for (Integer i : list) {
			int val = 1;
			if (map.containsKey(i)) {
				val = map.get(i) + 1;
			}
			map.put(i, val);
			max = Math.max(max, val);
		}

		List<Integer> res = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				res.add(entry.getKey());
			}
		}

		int[] resArr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			resArr[i] = res.get(i);
		}

		return resArr;

	}

	private void visit(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}

		visit(list, root.left);
		list.add(root.val);
		visit(list, root.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n21 = new TreeNode(2);
		n1.right = n2;
		n2.right = n21;
		
		System.out.println(Arrays.toString(new Solution().findMode(n1)));
	}
}
