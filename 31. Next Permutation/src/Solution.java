import java.util.Arrays;

public class Solution {
	public void nextPermutation(int[] nums) {
		int len = nums.length;

		int i = len - 2;

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i >= 0) {
			int minIndex = findIndex(nums, i + 1, len - 1, nums[i]);
			if (minIndex >= 0) {
				int temp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = temp;
			}
		}
//		 System.out.println("Found i=" + i);
		// for (int t: nums) {
		// System.out.println(t);
		// }
		quickSort(nums, i + 1, nums.length - 1);
	}

	private int findIndex(int[] arr, int start, int end, int minValue) {
		int res = -1;

		for (int i = start; i <= end; i++) {
			if (arr[i] > minValue) {
				if (res == -1) {
					res = i;
				} else if (arr[i] < arr[res]) {
					res = i;
				}
			}
		}

		return res;
	}

	private void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0) {
			return;
		}

		// System.out.println(low + " " + high);
		if (low > high) {
			return;
		}

		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		int i = low;
		int j = high;
		while (i <= j) {
			// System.out.println("loop " + i + j);
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (i < high) {
			quickSort(arr, i, high);
		}

		if (j > low) {
			quickSort(arr, low, j);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 1, 1 };
		new Solution().nextPermutation(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}