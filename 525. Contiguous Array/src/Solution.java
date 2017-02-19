import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public int findMaxLength(int[] nums) {
		int len = nums.length;
		int[] sum = new int[len + 1];
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				sum[i+1] = sum[i] - 1;
			} else {
				sum[i+1] = sum[i] + 1;
			}
		}
		
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i <= len; i++) {
			if (!map.containsKey(sum[i])) {
				map.put(sum[i], new ArrayList<Integer>());
			}
			
			map.get(sum[i]).add(i);
		}
		int max = 0;
		for (List<Integer> list: map.values()) {
			max = Math.max(max, list.get(list.size() - 1) - list.get(0));
		}

		
		

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.findMaxLength(new int[] { 0, 1, 0, 1 }));
	}
}
