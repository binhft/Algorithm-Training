import java.util.Arrays;

public class Solution {
	long[] cache;

	private long calculate(int n) {
		if (n <= 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (cache[n] != -1) {
			return cache[n];
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += calculate(i)*calculate(n-i-1);
		}
		cache[n] = res;
		return res;
	}
	public int numTrees(int n) {
		cache = new long[n+1];
		Arrays.fill(cache, -1);
		return (int) calculate(n);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().numTrees(10));
	}
}
