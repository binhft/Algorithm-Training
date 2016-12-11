import java.util.*;

public class Solution {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> posList = map.get(nums[i]);
			if (posList == null) {
				posList = new ArrayList<Integer>();
			}
			posList.add(i);
			map.put(nums[i], posList);
		}
		
		HashMap<Integer, Boolean> mark = new HashMap<Integer, Boolean>();
		
		for (int i = 0; i < nums.length; i++) {
			if (mark.get(nums[i]) != null) {
				continue;
			}
			int targetValue = nums[i]*(-1);
			HashMap<Integer, Boolean> markJ = new HashMap<Integer, Boolean>();
			for (int j = i + 1; j <  nums.length; j++) {
				if (markJ.get(nums[j]) != null) {
					continue;
				}
				int complement = targetValue - nums[j];
				ArrayList<Integer> posList = map.get(complement);
				if (posList != null) {
					for (Integer pos: posList) {
						if (pos > j) {
							ArrayList<Integer> resElement = new ArrayList<>();
							resElement.add(nums[i]);
							resElement.add(nums[j]);
							resElement.add(nums[pos]);
							res.add(resElement);
							mark.put(nums[i], true);
							markJ.put(nums[j], true);
							break;
						}
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
		
		List<List<Integer>> res = new Solution().threeSum(nums);

		for (List<Integer> ls: res) {
			for (Integer val: ls) {
				System.out.print(val + " ");
			}
			System.out.println("");
		}
	}
}
