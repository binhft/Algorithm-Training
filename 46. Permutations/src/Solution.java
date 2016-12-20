import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		res.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
			for (List<Integer> temp : res) {
				for (int j = 0; j < temp.size() + 1; j++) {
					temp.add(j, nums[i]);

					ArrayList<Integer> subRes = new ArrayList<Integer>(temp);
					current.add(subRes);

					temp.remove(j);
				}
			}

			res = new ArrayList<List<Integer>>(current);
		}

		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new Solution().permute(new int[] { 1, 2, 3 });
		
		for (List<Integer> r: res) {
			for (Integer i: r) {
				System.out.print(i);
			}
			
			System.out.println("");
		}
	}
}
