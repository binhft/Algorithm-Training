public class Solution {
	public int maxProfit(int[] prices) {
		int res = 0;
		if (prices == null || prices.length == 0) {
			return res;
		}
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				res += prices[i + 1] - prices[i];
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[] { 1, 3, 5, 1 }));
	}
}
