import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	static int gcf(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcf(b, a % b);
	}

	public boolean hasGroupsSizeX(int[] deck) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : deck) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer> list = new ArrayList<Integer>(map.values());
		if (list.size() == 0) {
			return false;
		}
		int x = list.get(0);
		for (int idx = 1; idx < list.size(); idx++) {
			x = gcf(x, list.get(idx));
		}
		return x >= 2;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hasGroupsSizeX(new int[] { 1, 1, 1,
				2, 2, 2, 3, 3 }));
		System.out.println(new Solution().hasGroupsSizeX(new int[] { 1, 2, 3,
				4, 4, 3, 2, 1 }));

	}
}
