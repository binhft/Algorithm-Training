import java.util.Random;

public class Solution {
	int count = 0;

	int[] copyArray(int[] original) {
		int[] res = new int[original.length];
		for (int i = 0; i < original.length; i++) {
			res[i] = original[i];
		}
		return res;
	}

	int[] sortArrayDesc(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}

	int[] removeItem(int[] original, int i) {
		int[] result = new int[original.length - 1];
		System.arraycopy(original, 0, result, 0, i);
		System.arraycopy(original, i + 1, result, i, result.length - i);
		return result;
	}

	boolean pack(int[] items, int[] bagFreeSpace, boolean[][] doesBagContainItem, int itemNum) {
		count++;
		if (itemNum == items.length) {
			return true;
		}
		if (count > 5e7) {
			return false;
		}

		// otherwise, keep traversing the state tree
		for (int i = 0; i < bagFreeSpace.length; i++) {
//			System.out.println(i + " " + itemNum);
			if (bagFreeSpace[i] >= items[itemNum]) {
				doesBagContainItem[i][itemNum] = true; // put item into bag
				bagFreeSpace[i] -= items[itemNum];
				if (pack(items, bagFreeSpace, doesBagContainItem, itemNum + 1)) // explore subtree
					return true;
				bagFreeSpace[i] += items[itemNum]; // take item out of the bag
				doesBagContainItem[i][itemNum] = false;
			}
		}

		return false;
	}

	int nextFit(int weight[], int n, int c) {
		// Initialize result (Count of bins) and remaining
		// capacity in current bin.
		int res = 0, bin_rem = 0;

		// Place items one by one
		for (int i = 0; i < n; i++) {
			// If this item can't fit in current bin
			if (weight[i] > bin_rem) {
				res++; // Use a new bin
				bin_rem = c - weight[i];
			} else
				bin_rem -= weight[i];
		}
		return res;
	}

	int bestFit(int weight[], int n, int c) {
		// Initialize result (Count of bins)
		int res = 0;

		// Create an array to store remaining space in bins
		// there can be at most n bins
		int[] bin_rem = new int[n];

		// Place items one by one
		for (int i = 0; i < n; i++) {
			// Find the best bin that ca\n accomodate
			// weight[i]
			int j;

			// Initialize minimum space left and index
			// of best bin
			int min = c + 1, bi = 0;

			for (j = 0; j < res; j++) {
				if (bin_rem[j] >= weight[i] && bin_rem[j] - weight[i] < min) {
					bi = j;
					min = bin_rem[j] - weight[i];
				}
			}

			// If no bin could accommodate weight[i],
			// create a new bin
			if (min == c + 1) {
				bin_rem[res] = c - weight[i];
				res++;
			} else // Assign the item to best bin
				bin_rem[bi] -= weight[i];
		}
		return res;
	}

	int getMin(int maxWeight, int[] candyWeights) {
		int sum = 0;
		int countHalf = 0;

		for (int i = 0; i < candyWeights.length; i++) {
			sum += candyWeights[i];
			if (candyWeights[i] * 2 > maxWeight) {
				countHalf += 1;
			}
		}
		return Math.max((int) Math.ceil(sum / maxWeight), countHalf);
	}

	int[] RandomizeArray(int[] array) {
		Random rgen = new Random(); // Random number generator

		for (int i = 0; i < array.length; i++) {
			int randomPosition = rgen.nextInt(array.length);
			int temp = array[i];
			array[i] = array[randomPosition];
			array[randomPosition] = temp;
		}

		return array;
	}

	int minimumBags(int maxWeight, int[] candyWeights) {
		if (candyWeights == null || candyWeights.length == 0) {
			return 0;
		}

		int n = candyWeights.length;
		for (int i = 0; i < n; i++) {
			if (candyWeights[i] > maxWeight) {
				return -1;
			}
		}

		int max = bestFit(candyWeights, n, maxWeight);
		for (int i = 0; i < 1000; i++) {
			int[] randomPos = RandomizeArray(candyWeights);
			int randomRes = bestFit(randomPos, n, maxWeight);
			max = Math.min(max, randomRes);
		}

		int min = getMin(maxWeight, candyWeights);
//		System.out.println("min = " + min);
//		System.out.println("max = " + max);
		if (max == min) {
			return min;
		}

		int[] sortedDesc = sortArrayDesc(candyWeights);
		while (max >= min) {
			if (max == min) {
				return min;
			}
			count = 0;
			max = max - 1;
//			System.out.println("check with max = " + max + " ...");
			int[] items = copyArray(sortedDesc);
			int[] bagFreeSpace = new int[max];
			for (int i = 0; i < max; i++) {
				bagFreeSpace[i] = maxWeight;
			}

			int cur = 0;
			for (int i = items.length - 1; i >= 0; i--) {
				if (items[i] * 2 > maxWeight) {
					bagFreeSpace[cur] -= items[i];
					cur += 1;
					items = removeItem(items, i);
				}
			}
			boolean[][] doesBagContainItem = new boolean[max][items.length];
			if (!pack(items, bagFreeSpace, doesBagContainItem, 0)) {
//				System.out.println("Count " + count);
				break;
			}
//			System.out.println("Count " + count);

		}
		return max + 1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().minimumBags(10, new int[] { 10, 9, 8, 7, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 1 }));
		System.out.println(new Solution().minimumBags(80, new int[] { 3, 3, 3, 3, 4, 4, 4, 4, 10, 10, 10, 10, 20, 21,
				22, 70, 60, 61, 62, 67, 78, 12, 13, 14, 15, 16, 17, 18, 19, 20 }));
		System.out.println(new Solution().minimumBags(10, new int[] { 8, 1, 1, 1, 1, 1, 1, 1 }));
		System.out.println(new Solution().minimumBags(100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 11, 12, 13, 9, 1,
				20, 60, 44, 45, 46, 47, 48, 49, 10, 21, 27, 17, 80, 49, 49, 49, 49 }));
		System.out.println(new Solution().minimumBags(100, new int[] { 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
				49, 49, 49, 24, 25, 26, 24, 25, 26, 24, 25, 26 }));
	}

}
