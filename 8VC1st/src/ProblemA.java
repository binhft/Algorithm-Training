import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		int m = 0;
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();

		int res = 0;
		if (m % 2 == 1) {
			res = 3;
		} else if (m == 2) {
			res = 4;
		} else {
			res = m - 2;
		}
		
		System.out.println(res);
	}
}
