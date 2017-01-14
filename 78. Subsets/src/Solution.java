import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> currentList = new ArrayList<Integer>();
		generate(res, currentList, nums, 0);
		return res;
	}

	private void generate(List<List<Integer>> res, List<Integer> currentList,
			int[] nums, int currentIndex) {
		if (currentIndex > nums.length) {
			return;
		}
		res.add(new ArrayList<>(currentList));
		for (int i = currentIndex; i < nums.length; i++) {
			currentList.add(nums[i]);
			generate(res, currentList, nums, i + 1);
			currentList.remove(currentList.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new Solution().subsets(new int[] {  });
		for (List<Integer> listItem : res) {
			System.out.println(listItem);
		}
	}
}
