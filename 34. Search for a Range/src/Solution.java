public class Solution {
	// public int[] searchRange(int[] nums, int target) {
	// int low = 0;
	// int high = nums.length - 1;
	// int res = -1;
	// while (low <= high) {
	//
	// int mid = low + (high - low) / 2;
	// if (nums[mid] < target) {
	// low = mid + 1;
	// } else if (nums[mid] > target) {
	// high = mid - 1;
	// } else {
	// res = mid;
	// break;
	// }
	// }
	// // System.out.println(res);
	// if (res > -1) {
	// low = res;
	// high = res;
	// while (low >= 0 && nums[low] == target) {
	// low--;
	// }
	//
	// while (high < nums.length && nums[high] == target) {
	// high++;
	// }
	//
	// return new int[] { low + 1, high - 1 };
	// } else {
	// return new int[] { -1, -1 };
	// }
	//
	// }

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[]{ -1, -1};
		}
		int i = 0;
		int j = nums.length - 1;
		int[] res = new int[]{-1,-1};
		while (i < j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] < target) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		if (nums[i] == target) {
			res[0] = i;
		}
		
		i = 0; j = nums.length - 1;
		while (i < j) {
			int mid = i + (j-i)/2 + 1;
			if (nums[mid] > target) {
				j = mid - 1;
			} else {
				i = mid;
			}
 		}
		if (nums[i] == target) {
			res[1] = i;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] res = new Solution().searchRange(new int[] {}, 0);
		System.out.println(res[0] + " " + res[1]);
	}
}
