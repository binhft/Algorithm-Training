import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();

		generate(res, first, 0, target, candidates, 0);
		return res;
	}

	private void generate(List<List<Integer>> res, List<Integer> currentList,
			int currentSum, int target, int[] candicates, int currentIndex) {
		if (currentSum == target) {
			res.add(new ArrayList<>(currentList));
			return;
		} else if (currentSum > target) {
			return;
		}

		for (int i = currentIndex; i < candicates.length; i++) {

			currentList.add(candicates[i]);
			generate(res, currentList, currentSum + candicates[i], target,
					candicates, i);
			currentList.remove(currentList.size() - 1);

		}
	}

	public static void main(String[] args) {
		int[] candicates = new int[] { 2, 3, 6, 7 };
		List<List<Integer>> res = new Solution().combinationSum(candicates, 7);

		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
