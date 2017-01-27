import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<Integer>();
		int[] hash = new int[256];
		for (int i = 0; i < p.length(); i++) {
			hash[p.charAt(i)]++;
		}

		int count = p.length();
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			if (hash[s.charAt(right)] >= 1) {
				count--;
			}
			hash[s.charAt(right)]--;
			right++;

			if (count == 0) {
				res.add(left);
			}

			if (right - left == p.length()) {
				if (hash[s.charAt(left)] >= 0) {
					count++;
				}
				hash[s.charAt(left)]++;
				left++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
		// System.out.println(new Solution().isAnagrams("abd", "abc"));
	}
}
