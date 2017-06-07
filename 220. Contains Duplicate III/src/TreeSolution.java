import java.util.TreeSet;

public class TreeSolution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || k < 1 || t < 0) {
			return false;
		}

		TreeSet<Long> value = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long numLong = (long) nums[i];
			Long floor = value.floor((numLong + t));
			Long ceil = value.ceiling((numLong - t));

			if ((floor != null && floor >= numLong)
					|| (ceil != null && ceil <= numLong)) {
				return true;
			}

			value.add(numLong);

			if (i >= k) {
				value.remove((long) nums[i - k]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new TreeSolution().containsNearbyAlmostDuplicate(
				new int[] { 4, 2 }, 2, 1));
	}

}
