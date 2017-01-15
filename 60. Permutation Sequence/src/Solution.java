import java.util.ArrayList;
import java.util.List;

public class Solution {
	// TLE when generate all possible solutions
	// public String getPermutation(int n, int k) {
	// if (k == 0 || n == 0) {
	// return "";
	// }
	//
	// List<List<Integer>> res = new ArrayList<List<Integer>>();
	// List<Integer> currentList = new ArrayList<Integer>();
	// boolean[] isUsed = new boolean[n + 1];
	// generate(res, currentList, n, k, isUsed);
	//
	// List<Integer> last_element = res.get(res.size() - 1);
	// StringBuilder sb = new StringBuilder();
	// for (Integer i : last_element) {
	// sb.append(i);
	// }
	// return sb.toString();
	// }
	//
	// private void generate(List<List<Integer>> res, List<Integer> currentRes,
	// int n, int target, boolean[] isUsed) {
	// if (currentRes.size() == n) {
	// res.add(new ArrayList<Integer>(currentRes));
	// return;
	// }
	// if (res.size() == target) {
	// return;
	// }
	// for (int i = 1; i <= n; i++) {
	// if (!isUsed[i]) {
	// currentRes.add(i);
	// isUsed[i] = true;
	// generate(res, currentRes, n, target, isUsed);
	// isUsed[i] = false;
	// currentRes.remove(currentRes.size() - 1);
	// }
	// }
	// }

	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		List<Integer> nums = new ArrayList<Integer>();
		int[] factorial = new int[n];
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		factorial[0] = 1;
		for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		k--;
		for (int i = 1; i <= n; i++) {
			int index = k / factorial[n - i];
			sb.append(nums.get(index));
			nums.remove(index);
			k = k - index * factorial[n - i];
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().getPermutation(3, 4));
	}
}
