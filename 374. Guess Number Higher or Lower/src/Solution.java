public class Solution extends GuessGame {
	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		int mid = 0;
		while (low <= high) {
			System.out.println(low + " " + high);
			mid = low + (high - low) / 2;
			int res = guess(mid);
			if (res == 0) {
				return mid;
			} else if (res == 1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().guessNumber(2126753390));
	}

}
