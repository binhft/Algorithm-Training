import java.util.HashMap;
import java.util.Map;

public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || k < 1 || t < 0) {
			return false;
		}

		Map<Long, Long> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			long tmp = (long)nums[i] - Integer.MIN_VALUE;
			long bucket = tmp / ((long)t + 1);
//			System.out.println(bucket);
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && tmp
							- map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1)
							- tmp <= t)) {
				return true;
			}

			if (map.entrySet().size() >= k) {
				long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, (long) tmp);
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().containsNearbyAlmostDuplicate(
				new int[] { 4, 2 }, 2, 1));
	}

}
