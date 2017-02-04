import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0;

		int n = sc.nextInt();
		// int num = 0;
		int[] arr = new int[n];
		long check = (long)n * (long)(n + 1) / 2L;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		if (sum % check != 0) {
			System.out.println("NO");
			return;
		}

		long k = sum / check;
		long s = 0;
		for (int i = 0; i < n; i++) {
			int current = arr[i];
			int next = arr[(i + 1) % n];
			long diff = next - current;
			if ((k - diff) % n != 0 || diff > k) {
				System.out.println("NO");
				return;
			}
			s += (k - diff) / n;
		}

		if (s != k) {

			System.out.println("NO");
			return;
		}

		System.out.println("YES");
	}
}
