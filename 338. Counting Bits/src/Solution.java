public class Solution {
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;
		int currentPowerOfTwo = -1;
		int currentMask = 0;
		for (int i = 1; i <= num; i++) {
			if ((i & (i - 1)) == 0) {
				currentPowerOfTwo += 1;
				currentMask = (int) Math.pow(2, currentPowerOfTwo);
				res[i] = 1;
			} else if (i % 2 == 1) {
				res[i] = res[i - 1] + 1;
			} else {
//				System.out.println("i = " + i);
//				System.out.println(currentMask);
				res[i] = res[(int) (i ^ currentMask)] + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] res = new Solution().countBits(10);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
