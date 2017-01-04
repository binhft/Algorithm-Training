import java.util.ArrayList;
import java.util.List;

public class Solution {
	private boolean isPalindrome(String s) {
		if (s.length() == 0) {
			return true;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> currentList = new ArrayList<String>();
		partitionRecursive(s, currentList, res);
		return res;
	}

	private void partitionRecursive(String s, List<String> list,
			List<List<String>> res) {
		if (s.length() == 0) {
			res.add(new ArrayList<String>(list));
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i + 1);
			String right = s.substring(i + 1);
			if (isPalindrome(left)) {
				list.add(left);
				partitionRecursive(right, list, res);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		List<List<String>> res = new ArrayList<List<String>>();
		res = new Solution().partition("aab");
		for (List<String> list: res) {
			System.out.println(list);
		}
	}
}
