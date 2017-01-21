import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public List<List<Integer>> findSubsequences(int[] nums) {
		HashSet<List<Integer>> res = new HashSet<List<Integer>>();
		if (nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		List<Integer> firstRes = new ArrayList<Integer>();
		firstRes.add(nums[0]);
		res.add(firstRes);

		for (int i = 1; i < nums.length; i++) {
			res = check(res, nums, i);
		}

		List<List<Integer>> realRes = new ArrayList<List<Integer>>();
		for (List<Integer> item : res) {
			if (item.size() > 1) {
				realRes.add(item);
			}
		}

		return realRes;

	}

	private HashSet<List<Integer>> check(HashSet<List<Integer>> currentRes,
			int[] nums, int currentIndex) {
		HashSet<List<Integer>> nextRes = new HashSet<List<Integer>>();
		int val = nums[currentIndex];
		for (List<Integer> list : currentRes) {
			if (list.get(list.size() - 1) <= val) {
				List<Integer> newRes = new ArrayList<Integer>(list);
				newRes.add(val);
				nextRes.add(newRes);
			}
			nextRes.add(list);
		}

		List<Integer> oneItem = new ArrayList<Integer>();
		oneItem.add(val);
		nextRes.add(oneItem);

		return nextRes;
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new Solution().findSubsequences(new int[] {
				1, 2, 3, 1, 1, 1 });
		for (List<Integer> item : res) {
			System.out.println(item);
		}
	}
}
