public class Solution {
	public int nthUglyNumber(int n) {
		int[] uglyNum = new int[n];
		uglyNum[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;

		int factor2 = 2;
		int factor3 = 3;
		int facetor5 = 5;

		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(factor2, factor3), facetor5);
			uglyNum[i] = min;

			if (min == factor2) {
				factor2 = 2 * uglyNum[++index2];
			}
			if (min == factor3) {
				factor3 = 3 * uglyNum[++index3];
			}
			if (min == facetor5) {
				facetor5 = 5 * uglyNum[++index5];
			}

		}
		return uglyNum[n - 1];

	}

	public static void main(String[] args) {
		System.out.println(new Solution().nthUglyNumber(4));
	}
}
