
public class Solution {
	long numberOfMilkBottles(int a, int b, long c) {
		long res = 0;
		while (c >= a) {
			long count = (int) c / a;
			res += count;
			c = c - a * count + count * b;	
		}
		return res;
	}
}
