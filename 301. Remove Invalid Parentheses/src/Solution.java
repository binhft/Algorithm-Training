import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();

		if (s == null) {
			return res;
		}

		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(s);
		visited.add(s);

		boolean hasFound = false;

		while (!queue.isEmpty()) {
			String item = queue.poll();
//			System.out.println(item);
			if (isValid(item)) {
//				System.out.println("Found valid");
				hasFound = true;
				res.add(item);
			}

			if (hasFound)
				continue;

			for (int i = 0; i < item.length(); i++) {
				if (item.charAt(i) != '(' && item.charAt(i) != ')') {
					continue;
				}

				String t = item.substring(0, i) + item.substring(i + 1);
				if (!visited.contains(t)) {
					queue.add(t);
					visited.add(t);
				}
			}
		}
		return res;
	}

	private boolean isValid(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
			} else if (c == ')' && count-- == 0) {
				return false;
			}
		}
		return count == 0;
	}

	public static void main(String[] args) {
		List<String> res = new Solution().removeInvalidParentheses("))");
//		System.out.println(res.size());
		System.out.println(res);
	}
}
