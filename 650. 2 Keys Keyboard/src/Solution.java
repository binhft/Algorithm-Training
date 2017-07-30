public class Solution {
	public int minSteps(int n) {
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				ans += i;
				n /= i;
			}
		}

		return ans;

	}

	public static void main(String[] args) {
		System.out.println(new Solution().minSteps(7));
	}
}
