import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> last = new ArrayList<Integer>();
		last.add(0);
		for (List<Integer> list : triangle) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			int count = -1;
			for (int num : list) {
				count++;
				if (count == 0) {
					newList.add(num + last.get(0));
				} else if (count == list.size() - 1) {
					newList.add(num + last.get(last.size() - 1));
				} else {
					newList.add(Math.min(num + last.get(count),
							num + last.get(count - 1)));
				}
			}
			last = new ArrayList<>(newList);
		}

		int min = Integer.MAX_VALUE;
		for (int num : last) {
			min = Math.min(min, num);
		}
		return min;
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);

		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);

		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);

		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);

		List<List<Integer>> input = new ArrayList<List<Integer>>();
		input.add(l1);
		input.add(l2);
		input.add(l3);
		 input.add(l4);

		System.out.println(new Solution().minimumTotal(input));
	}
}
