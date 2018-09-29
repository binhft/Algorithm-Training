import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,
				b) -> {
			if (a.getValue() == b.getValue()) {
				return b.getKey().compareTo(a.getKey());
			}
			return a.getValue() - b.getValue();
		});
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.add(entry);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		while (!pq.isEmpty()) {
			res.add(pq.poll().getKey());
		}
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().topKFrequent(
				new String[] { "the", "day", "is", "sunny", "the", "the",
						"the", "sunny", "is", "is" }, 4));
	}
}
