import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (s == null || words == null || words.length == 0) {
			return res;
		}

		int wl = words[0].length();
		int N = s.length();
		int M = words.length;

		Map<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> currMap = new HashMap<String, Integer>();
		for (String item : words) {
			map.put(item, map.getOrDefault(item, 0) + 1);
		}

		String str = null;
		String tmp = null;

		for (int i = 0; i < wl; i++) {
			int count = 0;
			int start = i;

			for (int r = i; r + wl <= N; r += wl) {
				str = s.substring(r, r + wl);
				if (map.containsKey(str)) {
					currMap.put(str, currMap.getOrDefault(str, 0) + 1);
					if (currMap.get(str) <= map.get(str)) {
						count++;
					}

					while (currMap.get(str) > map.get(str)) {
						tmp = s.substring(start, start + wl);
						currMap.put(tmp, currMap.get(tmp) - 1);
						start += wl;
						if (currMap.get(tmp) < map.get(tmp)) {
							count--;
						}
					}

					if (count == M) {
						res.add(start);
						tmp = s.substring(start, start + wl);
						currMap.put(tmp, currMap.get(tmp) - 1);
						start += wl;
						count--;

					}
				} else {
					currMap.clear();
					count = 0;
					start = r + wl;
				}
			}
			
			currMap.clear();
		}
		
		return res;

	}

	public static void main(String[] args) {
		List<Integer> res = new Solution().findSubstring("barfoothefoobarman",
				new String[] { "foo", "bar" });
		System.out.println(res);
	}
}
