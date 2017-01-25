import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();

		List<String> seed = new ArrayList<String>();

		helper(res, seed, s.length(), s);

		return res;

	}

	private void helper(List<String> res, List<String> currentIp,
			int currentIndex, String ipStr) {
		// System.out.println(currentIndex);
//		System.out.println(currentIp);
		if (currentIndex <= 0) {
			if (currentIp.size() == 4) {
				ArrayList<String> temp = new ArrayList<String>(currentIp);
				Collections.reverse(temp);
				res.add(String.join(".", temp));
			}
			return;
		} else if (currentIp.size() > 4) {
			return;
		}

		int i = currentIndex - 1;
		while (i >= 0
				&& Integer.valueOf(ipStr.substring(i, currentIndex)) <= 255) {
			
			if (ipStr.substring(i, currentIndex).startsWith("0") && ipStr.substring(i, currentIndex).length() > 1) {
				i--;
				continue;
			} else {
				currentIp.add(ipStr.substring(i, currentIndex));
				helper(res, currentIp, i, ipStr);
				currentIp.remove(currentIp.size() - 1);
				i--;
			}
			
		}
	}

	public static void main(String[] args) {
		List<String> res = new Solution().restoreIpAddresses("010010");
		System.out.println(res);
	}
}
