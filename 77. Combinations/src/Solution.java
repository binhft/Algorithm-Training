import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		generate(res, firstList, 1, k, n);
		return res;
	}

	private void generate(List<List<Integer>> res, List<Integer> currentList,
			int currentIndex, int size, int max) {
		if (currentList.size() == size) {
			res.add(new ArrayList<Integer>(currentList));
			return;
		}

		for (int i = currentIndex; i <= max; i++) {
			currentList.add(i);
			generate(res, currentList, i + 1, size, max);
			currentList.remove(currentList.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new Solution().combine(4, 0);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}
