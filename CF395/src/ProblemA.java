import java.util.Scanner;


public class ProblemA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println(new ProblemA().findGcd(10, 20));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int z = sc.nextInt();
		int res = 0;
		
		int gcd = n*m/findGcd(n, m);
		res = z/gcd;
		
		
		
		System.out.println(res);
	}
	
	private static int findGcd(int a, int b) {
		if (a == 0 || b == 0) return a + b;
		return findGcd(b, a % b);
	}
}
