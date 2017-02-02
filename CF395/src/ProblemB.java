import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(input));
		for (int i = 0; i < n / 2; i++) {
			if (i % 2 == 0) {
				int temp = input[n - i - 1];
				input[n - i - 1] = input[i];
				input[i] = temp;
			}
		}
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			res.append(input[i] + " ");
		}
		System.out.println(res);
		
//		for (int i = 0; i < n; i++) {
//			if (i % 2 == 1) {
//				System.out.print(input[i] + " ");
//			} else {
//				System.out.print(input[n - i - 1] + " ");
//			}
//			
//		}
	}
}
