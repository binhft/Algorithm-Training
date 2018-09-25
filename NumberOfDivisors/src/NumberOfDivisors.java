
public class NumberOfDivisors {

	
	long numOfDivisors(long n) {

		long i = 2, ans = 2;
		for (; i * i <= n; i++) {
			if (n % i == 0)
				ans += 2;
		}

		if ((i - 1) * (i - 1) == n)
			ans--;

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new NumberOfDivisors().numOfDivisors(4));
	}
}
