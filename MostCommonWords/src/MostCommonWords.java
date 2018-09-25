import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWords {

	String[] mostCommonWords(String text, int n) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] str = text.split("[^a-zA-Z']+");
		for (String s : str) {
			String sLower = s.toLowerCase();
			if (map.containsKey(sLower)) {
				map.put(sLower, map.get(sLower) + 1);
			} else {
				map.put(sLower, 1);
			}
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>> () {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            	int cmp1 = b.getValue().compareTo(a.getValue());
    			if (cmp1 != 0) {
    				return cmp1;
    			} else {
    				return a.getKey().compareTo(b.getKey());
    			}
            }
        });
		

		String[] ans = new String[n];
		int idx = 0;
		for (idx = 0; idx < n && idx < list.size(); idx ++) {
			ans[idx] = list.get(idx).getKey();
		}
		while (idx < n) {
			ans[idx] = "";
			idx++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] res = (new MostCommonWords()).mostCommonWords("He is a pupil, and she is a student aa aa", 100);
		System.out.println(Arrays.toString(res));
	}
}
