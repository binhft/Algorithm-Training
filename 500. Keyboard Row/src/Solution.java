import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public String[] findWords(String[] words) {
		List<String> res = new ArrayList<String>();
		for (String word : words) {
			String check = word.toLowerCase();
			if (check.matches("[qwertyuiop]*") || check.matches("[asdfghjkl]*")
					|| check.matches("[zxcvbnm]*")) {
				res.add(word);
			}
		}
		String[] stockArr = new String[res.size()];
		stockArr = res.toArray(stockArr);
		return stockArr;
	}

	public static void main(String[] args) {
		String[] input = new String[] { "Hello", "Alaska", "Dad", "Peace" };
		String[] res = new Solution().findWords(input);
		System.out.println(Arrays.toString(res));
	}
}
