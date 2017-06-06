import java.util.Arrays;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];

		int low = 0;
		int high = numbers.length - 1;

		int sum = numbers[low] + numbers[high];
		while (sum != target) {
			while (numbers[low] + numbers[high] > target) {
				high--;
			}
			while (numbers[low] + numbers[high] < target) {
				low++;
			}
			sum = numbers[low] + numbers[high];
		}

		res[0] = low + 1;
		res[1] = high + 1;
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 7, 11, 15 };
		int[] res = new Solution().twoSum(arr, 9);
		System.out.println(Arrays.toString(res));
	}
}
