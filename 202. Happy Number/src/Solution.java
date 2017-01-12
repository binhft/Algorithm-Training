import java.util.HashSet;

public class Solution {
	// public boolean isHappy(int n) {
	// HashSet<Integer> set = new HashSet<Integer>();
	// int value = n;
	// while (value != 1 && !set.contains(value)) {
	// set.add(value);
	// int total = 0;
	// while (value > 0) {
	// total += (value % 10) * (value % 10);
	// value = value / 10;
	// }
	// value = total;
	// }
	//
	// if (value != 1) {
	// return false;
	// }
	// return true;
	// }

	private int totalSquare(int n) {
		int total = 0;
		while (n > 0) {
			total += (n % 10) * (n % 10);
			n = n / 10;
		}

		return total;
	}

	public boolean isHappy(int n) {
		int first = totalSquare(n);
		int last = totalSquare(totalSquare(n));
		while (first != last) {
			first = totalSquare(first);
			last = totalSquare(totalSquare(last));
			if (last == 1) {
				return true;
			}
		}

		if (first == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isHappy(0));
	}
}
