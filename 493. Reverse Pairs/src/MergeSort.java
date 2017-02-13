public class MergeSort {
	public static void merged(int[] arr, int low, int mid, int high) {
		int[] helpArr = new int[arr.length];
		System.arraycopy(arr, 0, helpArr, 0, arr.length);

		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				arr[k] = helpArr[j++];
			} else if (j > high) {
				arr[k] = helpArr[i++];
			} else if (helpArr[i] < helpArr[j]) {
				arr[k] = helpArr[i++];
			} else {
				arr[k] = helpArr[j++];
			}
		}
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int mid = low + (high - low) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merged(arr, low, mid, high);
	}

	public static void sortArray(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 9, 8, 7, 6, 1, 2, 5, 4 };
		sortArray(a);

		for (Integer x : a) {
			System.out.println(x);
		}
	}
}
