import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();

		generate(res, first, 0, n, 1, k);
		return res;
	}

	private void generate(List<List<Integer>> res, List<Integer> currentList,
			int currentSum, int target, int currentNumber, int total_length) {
		if (currentSum == target && currentList.size() == total_length) {
			res.add(new ArrayList<>(currentList));
			return;
		} else if (currentSum > target || currentList.size() > total_length) {
			return;
		}

		for (int i = currentNumber; i < 10; i++) {
			currentList.add(i);
			generate(res, currentList, currentSum + i, target, i + 1, total_length);
			currentList.remove(currentList.size() - 1);

		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new Solution().combinationSum3(3, 7);

		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
