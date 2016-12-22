import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		boolean[] visited = new boolean[nums.length];
		ArrayList<Integer> initList = new ArrayList<Integer>();
		dfs(nums, visited, res, initList);
		return res;
	}
	
	private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> currentList) {
		if (currentList.size() == nums.length) {
			res.add(new ArrayList<Integer>(currentList));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) continue;
			if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
			visited[i] = true;
			currentList.add(nums[i]);
			dfs(nums, visited, res, currentList);
			visited[i] = false;
			currentList.remove(currentList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = new Solution().permuteUnique(new int[]{1,3,1,2});
		for (List<Integer> list: res) {
			for (Integer i: list) {
				System.out.print(i);
			}
			System.out.println("");
		}
	}
}