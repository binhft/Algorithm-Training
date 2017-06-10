import java.util.Arrays;

public class Solution {
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);

		int min = Integer.MIN_VALUE;

		for (int i : houses) {
			int index = Arrays.binarySearch(heaters, i);
			if (index < 0) {
				index = -(index + 1);
			}
			int leftDist = index - 1 >= 0 ? i - heaters[index - 1]
					: Integer.MAX_VALUE;
			int rightDist = index < heaters.length ? heaters[index] - i
					: Integer.MAX_VALUE;

			min = Math.max(min, Math.min(leftDist, rightDist));

		}

		return min;

	}

	public static void main(String[] args) {
		int[] houses = new int[] { 1, 5 };
		int[] heaters = new int[] { 2 };
		System.out.println(new Solution().findRadius(houses, heaters));
	}
}
