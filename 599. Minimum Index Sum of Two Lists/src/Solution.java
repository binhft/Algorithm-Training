import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		if (list1 == null || list2 == null || list1.length == 0
				|| list2.length == 0) {
			return new String[0];
		}
		List<String> list = new ArrayList<String>();

		int min = Integer.MAX_VALUE;

		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i++) {
			map1.put(list1[i], i);
		}
		
		for (int j = 0; j < list2.length; j++) {
			String tmp = list2[j];
			if (map1.containsKey(tmp)) {
				int idx = map1.get(tmp);
				if (idx + j < min) {
					min = idx + j;
					list = new ArrayList<String>();
					list.add(tmp);
				} else if (idx + j == min) {
					list.add(tmp);
				}
			}
		}

		String[] res = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}

		return res;
	}

	public static void main(String[] args) {
		String[] s1 = new String[] { "Shogun", "Tapioca Express",
				"Burger King", "KFC" };
		String[] s2 = new String[] { "Piatti", "The Grill at Torrey Pines",
				"Hungry Hunter Steakhouse", "Shogun" };

		 String[] res = new Solution().findRestaurant(s1, s2);
		 System.out.println(Arrays.toString(res));
	
	}
}
