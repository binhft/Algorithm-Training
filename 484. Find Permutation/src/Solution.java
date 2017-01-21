public class Solution {
	public int[] findPermutation(String s) {

		int len = s.length();
		int[] res = new int[len + 1];

		if (len == 0) {
			return new int[0];
		}

		int currentNumber = 1;
		res[0] = 1;

		for (int i = 1; i <= len; i++) {
			char c = s.charAt(i-1);
			currentNumber++;
			if (c == 'D') {
				int j = i - 1;
				while (j > 0 && res[j] < res[j-1]) {
					j--;
				}
				
				for (int k = i; k > j; k--) {
					res[k] = res[k-1];
				}
				
				res[j] = currentNumber;
			} else if (c == 'I') {
				res[i] = currentNumber;
			}

		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] res = new Solution().findPermutation("I");
		for (int i: res) {
			System.out.print(i + " ");
		}
	}
}
