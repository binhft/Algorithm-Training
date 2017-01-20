import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] citizen = new int[n + 1];
		int res = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			citizen[i] = sc.nextInt();
			max = Math.max(citizen[i], max);
		}

		for (int i = 0; i < n; i++) {
			res += (max - citizen[i]);
		}

		System.out.println(res);

	}
}
