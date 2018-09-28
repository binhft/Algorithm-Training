import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	// Hashmap solution
	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int idx = 0; idx < s.length(); idx++) {
			char c = s.charAt(idx);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c,  1);
			}
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>> () {
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
            	return b.getValue().compareTo(a.getValue());
            }
		});
		
		char[] res = new char[s.length()];
		int count = 0;
		for (Map.Entry<Character, Integer> item: list) {
			for (int idx = 0; idx < item.getValue(); idx++) {
				res[count] = item.getKey();
				count += 1;
			}
		}
		return String.valueOf(res);
	}
	
//	public static void main(String[] args) {
//		System.out.println(new Solution().frequencySort("tree"));
//		System.out.println(new Solution().frequencySort("cccaaa"));
//		System.out.println(new Solution().frequencySort("Aabb"));
//	}
}
