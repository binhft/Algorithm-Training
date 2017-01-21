public class Solution {
	public int hIndex(int[] citations) {
		int len = citations.length;
		int[] check = new int[len + 1];

		for (int c : citations) {
			if (c > len) {
				check[len]++;
			} else {
				check[c]++;
			}
		}

		int total = 0;
		for (int i = len; i >= 0; i--) {
			total += check[i];
			if (total >= i) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hIndex(new int[] { 1, 3, 5, 6, 10,
				20, 30 }));
	}
}
