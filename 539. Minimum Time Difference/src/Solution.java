import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int findMinDifference(List<String> timePoints) {
		if (timePoints == null || timePoints.size() == 0) {
			return 0;
		}

		int[] minutes = new int[timePoints.size()];

		int i = 0;
		for (String timeStamp : timePoints) {
			String[] input = timeStamp.split(":");
			int hour = Integer.parseInt(input[0]);
			int min = Integer.parseInt(input[1]);
			minutes[i] = hour * 60 + min;
			i++;
		}

		// System.out.println(Arrays.toString(minutes));
		Arrays.sort(minutes);

		int diff = Integer.MAX_VALUE;
		for (int k = 0; k < minutes.length; k++) {
			if (k == minutes.length - 1) {
				diff = Math.min(diff, minutes[k] - minutes[0]);
				diff = Math.min(diff,  1440 + minutes[0] - minutes[k]);
			} else {
				diff = Math.min(diff, minutes[k + 1] - minutes[k]);
				diff = Math.min(diff, 1440 + minutes[k] - minutes[k + 1]);
			}
		}

		return diff;
	}

	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		input.add("05:31");
		input.add("22:08");
		input.add("00:35");

		System.out.println(new Solution().findMinDifference(input));
	}
}
