import java.util.Arrays;

public class MergeSort2 {

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] auxArr = new int[arr.length];
		System.arraycopy(arr, 0, auxArr, 0, arr.length);

		int i = low;
		int j = mid + 1;

		for (int k = low; k <= high; k++) {
			if (i > mid) {
				arr[k] = auxArr[j++];
			} else if (j > high) {
				arr[k] = auxArr[i++];
			} else if (auxArr[i] > auxArr[j]) {
				arr[k] = auxArr[j++];
			} else {
				arr[k] = auxArr[i++];
			}
		}
	}

	private static void sort(int[] arr, int low, int high) {
		int mid = low + (high - low) / 2;
		sort(arr, low, mid);
		sort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public static void main(String[] args) {
		int[] testArr = new int[] { 9, 5, 6, 7, 0 };
		sort(testArr, 0, testArr.length - 1);
		for (Integer x: testArr) {
			System.out.println(x);
		}
	}
}
