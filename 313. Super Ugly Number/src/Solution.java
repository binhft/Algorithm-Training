public class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;
		int[] index = new int[primes.length];

		for (int i = 1; i < n; i++) {
			uglyNumbers[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				uglyNumbers[i] = Math.min(uglyNumbers[i], uglyNumbers[index[j]] * primes[j]);
			}
			for (int j = 0; j < primes.length; j++) {
				if (uglyNumbers[i] == primes[j]*uglyNumbers[index[j]]) {
					index[j] += 1;
				}
			}
		}
		return uglyNumbers[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().nthSuperUglyNumber(4, new int[] { 2,
				3, 5 }));
	}
}
