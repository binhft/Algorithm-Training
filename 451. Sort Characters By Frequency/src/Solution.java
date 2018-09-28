import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	// Hashmap solution
//	public String frequencySort(String s) {
//		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//		for (int idx = 0; idx < s.length(); idx++) {
//			char c = s.charAt(idx);
//			if (map.containsKey(c)) {
//				map.put(c, map.get(c) + 1);
//			} else {
//				map.put(c,  1);
//			}
//		}
//		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
//		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>> () {
//            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
//            	return b.getValue().compareTo(a.getValue());
//            }
//		});
//		
//		char[] res = new char[s.length()];
//		int count = 0;
//		for (Map.Entry<Character, Integer> item: list) {
//			for (int idx = 0; idx < item.getValue(); idx++) {
//				res[count] = item.getKey();
//				count += 1;
//			}
//		}
//		return String.valueOf(res);
//	}

	// bucket solution
//	public String frequencySort(String s) {
//		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//		for (int idx = 0; idx < s.length(); idx++) {
//			char c = s.charAt(idx);
//			map.put(c, map.getOrDefault(c, 0) + 1);
//		}
//		List<Character>[] bucket = new List[s.length() + 1];
//		for (char key: map.keySet()) {
//			int freq = map.get(key);
//			if (bucket[freq] == null) {
//				bucket[freq] = new ArrayList<Character>();
//			}
//			bucket[freq].add(key);
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (int pos = bucket.length - 1; pos >= 0; pos--) {
//			if (bucket[pos] != null) {
//				for (char c : bucket[pos]) {
//					for (int i = 0; i < map.get(c); i++) {
//						sb.append(c);
//					}
//				}
//			}
//		}
//		return sb.toString();
//	}

	// priority queue solution
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int idx = 0; idx < s.length(); idx++) {
			char c = s.charAt(idx);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		queue.addAll(map.entrySet());
		
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Map.Entry e = queue.poll();
			for (int idx = 0; idx < (int)e.getValue(); idx++) {
				sb.append(e.getKey());
			}
		}
		return sb.toString();
	}

//	public static void main(String[] args) {
//		System.out.println(new Solution().frequencySort("tree"));
//		System.out.println(new Solution().frequencySort("cccaaa"));
//		System.out.println(new Solution().frequencySort("Aabb"));
//	}
}
