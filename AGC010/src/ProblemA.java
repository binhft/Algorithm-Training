import java.util.Scanner;


public class ProblemA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int numOdd = 0;
		int numEven = 0;
		int num = 0;
		for (int i = 0; i < n; i++) {
			num = sc.nextInt();
			if (num % 2 == 0) {
				numEven++;
			} else {
				numOdd++;
			}
		}
		numEven += numOdd/2;
		numOdd = numOdd%2;
		
		
//		System.out.println(numOdd + " " + numEven);
		if (numEven > 0) {
			numEven = 1;
		} else {
			numEven = 0;
		}
		
		if (numOdd + numEven == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
