import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || i > 0 && nums[i] != nums[i-1]) {
				int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1]) {
							low ++;
						}
						while (high > low && nums[high] == nums[high - 1]) {
							high--;
						}
						low++;
						high--;
					} else if (nums[low] + nums[high] > sum) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		
	
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,
				-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,
				-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,
				7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		
		List<List<Integer>> res = new Solution2().threeSum(nums);

		for (List<Integer> ls: res) {
			for (Integer val: ls) {
				System.out.print(val + " ");
			}
			System.out.println("");
		}
	}
}
