import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
	public static void main(String[] args) {
		int n = 0;
		int p = 0;
		int[] a;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = sc.nextInt();

		a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);
		

		int res = 0;
		int last = -5;

		for (int i = 0; i < n; i++) {
			int temp = (int) Math.ceil(a[i] * 1.0 / p);
//			System.out.println("Prep " + temp + " " + last);
			while (temp <= last) {
				temp++;
			}
			last = temp;
//			System.out.println(temp);
			
			res += temp;
		}

		System.out.println(res);

	}
}
