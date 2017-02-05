import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
	private int calculate(TreeNode root, List<Integer> res) {
		if (root == null) {
			return 0;
		}

		int leftVal = 0;
		if (root.left != null) {
			leftVal = calculate(root.left, res);
		}

		int rightVal = 0;
		if (root.right != null) {
			rightVal = calculate(root.right, res);
		}

		int newVal = root.val + leftVal + rightVal;
		res.add(newVal);
		return newVal;
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		calculate(root, res);
		// System.out.println(res);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int max = 0;
		for (int val : res) {
			map.put(val, map.getOrDefault(val, 0) + 1);
			max = Math.max(map.get(val), max);
		}
		// System.out.println(map);
		List<Integer> dat = new ArrayList<Integer>();

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if ((Integer) pair.getValue() == max) {
				dat.add((Integer) pair.getKey());
			}
			it.remove(); // avoids a ConcurrentModificationException
		}

		int[] stockArr = new int[dat.size()];
		int count = 0;
		for (int val : dat) {
			stockArr[count] = val;
			count++;
		}
		return stockArr;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(-3);
		TreeNode t3 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;

		int[] res = new Solution().findFrequentTreeSum(null);
		System.out.println(Arrays.toString(res));
	}
}
