import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		List<Integer> res = new ArrayList<Integer>();
		List<Integer>[] bucket = new List[nums.length + 1];
		for (Integer key: map.keySet()) {
			int feq = map.get(key);
			if (bucket[feq] == null) {
				bucket[feq] = new ArrayList<Integer>();
			}
			bucket[feq].add(key);
		}
		int count = 0;
		for (int idx = bucket.length - 1; idx >= 0 && count < k; idx--) {
			if (bucket[idx] != null) {
				for (int i = 0; i < bucket[idx].size() && count < k; i++) {
					res.add(bucket[idx].get(i));
					count ++;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2));
		System.out.println(new Solution().topKFrequent(new int[]{1}, 1));
	}
}
