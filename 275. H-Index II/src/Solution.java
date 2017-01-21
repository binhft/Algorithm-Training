public class Solution {
	public int hIndex(int[] citations) {
		int start = 0;
		int len = citations.length;
		int end = len - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] == len - mid) {
				return len - mid;
			} else if (citations[mid] < len - mid) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return len - (end + 1);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hIndex(new int[] { 1, 3, 4, 6, 10,
				20, 30 }));
	}
}
