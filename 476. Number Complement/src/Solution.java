public class Solution {
	public int findComplement(int num) {
		int res = 0;
		int power2 = 1;
		while (num > 0) {
			res = res + (1 - (num%2)) * power2;
			power2 *= 2;
			num /= 2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().findComplement(2));
	}
}
