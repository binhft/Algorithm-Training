import java.util.*;


public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(); // integer, position
		
		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> posList = map.get(nums[i]);
			if (posList == null) {
				posList = new ArrayList<Integer>();
			}
			
			posList.add(i);
			map.put(nums[i], posList);
		}
		
		for (Integer key: map.keySet()) {
			int remain = target - key;
			if (remain != key) {
				if (map.get(remain) != null) {
					return new int[] {
						map.get(key).get(0),
						map.get(remain).get(0)
					};
				}
			} else {
				if (map.get(key).size() >= 2) {
					return new int[] {
						map.get(key).get(0),
						map.get(key).get(1)
					};
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{3, 2, 4};
		int target = 6;
		
		int[] res = new TwoSum().twoSum(nums, target);
		System.out.println(res[0] + " " + res[1]);
		
	}
}
