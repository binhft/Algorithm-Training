import java.util.LinkedList;
import java.util.List;

public class Solution {

	public List<String> letterCombinations(String digits) {

		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl",
				"mno", "pqrs", "tuv", "wxyz" };

		LinkedList<String> res = new LinkedList<String>();
		if (digits.length() == 0) {
			return res;
		}
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			int pos = digits.charAt(i) - '0';
			while (res.peek().length() == i) {
				String t = res.remove();
				for (char s : mapping[pos].toCharArray()) {
					res.add(t + s);
				}
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("234"));
	}
}
