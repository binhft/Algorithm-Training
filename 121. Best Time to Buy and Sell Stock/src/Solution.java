public class Solution {
	public int maxProfit1(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxProfit = Integer.MIN_VALUE;
		int currentMin = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			currentMin = Math.min(currentMin, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - currentMin);
		}

		return maxProfit;
	}
	
	public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[] { 1, 7, 4, 11 }));
	}
}
