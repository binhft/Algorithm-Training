public class Solution extends VersionControl {
	public int firstBadVersion(int n) {
		int low = 1, high = n;
		while (low <= high) {
//			System.out.println(low + " " + high);
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid)) {
				if (mid == low || !isBadVersion(mid - 1)) {
					return mid;
				} else {
					high = mid - 1;

				}
			} else {
				low = mid + 1;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().firstBadVersion(100));
	}
}
