import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
			if (i > currentIndex && candicates[i] == candicates[i-1]) {
				continue;
			}
			currentList.add(candicates[i]);
			generate(res, currentList, currentSum + candicates[i], target,
					candicates, i + 1);
			currentList.remove(currentList.size() - 1);

		}
	}

	public static void main(String[] args) {
		int[] candicates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> res = new Solution().combinationSum2(candicates, 8);

		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
