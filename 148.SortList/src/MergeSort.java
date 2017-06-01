public class MergeSort {
	public static boolean less(int a, int b) {
		if (a < b) {
			return true;
		} else {
			return false;
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int[] auxArr = new int[arr.length];
		System.arraycopy(arr, 0, auxArr, 0, arr.length);

		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			// System.out.println(i + " " + j);
			if (i > mid) {
				arr[k] = auxArr[j++];
			} else if (j > high) {
				arr[k] = auxArr[i++];
			} else if (less(auxArr[i], auxArr[j])) {
				arr[k] = auxArr[i++];
			} else {
				arr[k] = auxArr[j++];
			}
		}
	}

	public static void sort(int[] arr, int low, int high) {
		if (high <= low)
			return;
		int mid = low + (high - low) / 2;
		sort(arr, low, mid);
		sort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public static void sortArray(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 9, 8, 7, 6, 1, 2, 5, 4 };
		sortArray(a);

		for (Integer x : a) {
			System.out.println(x);
		}
	}
}
