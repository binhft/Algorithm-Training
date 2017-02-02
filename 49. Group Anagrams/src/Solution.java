import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < strs.length; i++) {
			String item = strs[i];
			char[] charArr = item.toCharArray();
			Arrays.sort(charArr);
			String value = new String(charArr);
//			System.out.println(value);
			if (!map.containsKey(value)) {
//				System.out.println("not contain");
				map.put(value, new ArrayList<String>());
			}
			map.get(value).add(item);
		}

		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		String[] input = new String[] { "eat", "tea", "tan", "ate", "nat",
				"bat" };
		
		List<List<String>> res = new Solution().groupAnagrams(input);
		for (List<String> item: res) {
			System.out.println(item);
		}
	}
}
