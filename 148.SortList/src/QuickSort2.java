
public class QuickSort2 {
	private void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0) {
			return;
		}
		if (low > high) {
			return;
		}
		
		int mid = low + (high-low)/2;
		int pivot = arr[mid];
		
		int i = low;
		int j = high;
		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
			
			if (i <=j ) {
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
		
		if (low < j) {
			quickSort(arr, low, j);
		}
	}
	
	public static void main(String[] args) {
		int[] test_arr = new int[]{2, 4, 1, 5, 3};
		new QuickSort2().quickSort(test_arr, 0, test_arr.length - 1);
		
		for (Integer i: test_arr) {
			System.out.println(i);
		}
	}
}
