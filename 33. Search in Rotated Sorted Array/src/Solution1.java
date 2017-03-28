public class Solution1 {
	public int search(int[] nums, int target) {

		int len = nums.length;
		// find minimum elements
		int low = 0, high = len - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
//			System.out.println(mid);
			if (nums[mid] < nums[high]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		int root = low;
//		System.out.println(root);
		low = 0;
		high = len - 1;
		while (low <= high) {
			int mid = low + (high - low) /2; 
			int realMid = (mid + root) % len;
//			System.out.println(nums[realMid]);
			if (nums[realMid] == target) {
				return realMid;
			} else if (nums[realMid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution1().search(new int[] {5,1,2}, 5));
	}
}
