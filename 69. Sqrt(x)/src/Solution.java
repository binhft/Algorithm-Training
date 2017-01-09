public class Solution {
	public int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int low = 0, high = x;
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (mid > x/mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
				ans = mid;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().mySqrt(1));
	}
}
