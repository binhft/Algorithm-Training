import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<String> wordSubsets(String[] A, String[] B) {
		List<String> res = new ArrayList<String>();
		HashMap<Character, Integer> map = new HashMap<>();
		for (String s : B) {
			HashMap<Character, Integer> submap = new HashMap<Character, Integer>();
			for (int idx = 0; idx < s.length(); idx++) {
				char c = s.charAt(idx);
				submap.put(c, submap.getOrDefault(c, 0) + 1);
			}
			for (Map.Entry<Character, Integer> entry : submap.entrySet()) {
				map.put(entry.getKey(),
						Math.max(entry.getValue(),
								map.getOrDefault(entry.getKey(), 0)));
			}
		}
		for (String s : A) {
			HashMap<Character, Integer> submap = new HashMap<Character, Integer>();
			boolean isOk = true;
			for (int idx = 0; idx < s.length(); idx++) {
				char c = s.charAt(idx);
				submap.put(c, submap.getOrDefault(c, 0) + 1);
			}
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() > submap.getOrDefault(entry.getKey(), 0)) {
					isOk = false;
					break;
				}
			}
			if (isOk) {
				res.add(s);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] A = new String[] { "amazon","apple","facebook","google","leetcode" };
		String[] B = new String[] { "lo", "eo" };
		System.out.println(new Solution().wordSubsets(A, B));
	}
}
