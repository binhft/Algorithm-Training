import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	// Solution 1
//	public List<Integer> findDisappearedNumbers(int[] nums) {
//		List<Integer> res = new ArrayList<Integer>();
//
//		Set<Integer> set = new HashSet<Integer>();
//
//		for (int i = 0; i < nums.length; i++) {
//			set.add(nums[i]);
//		}
//
//		for (int i = 1; i <= nums.length; i++) {
//			if (!set.contains(i)) {
//				res.add(i);
//			}
//		}
//		return res;
//	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != (i + 1)) {
				res.add(i+1);
			}
		}
		return res;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findDisappearedNumbers(new int[] { 4,
				3, 2, 7, 8, 2, 3, 1 }));
	}
}
