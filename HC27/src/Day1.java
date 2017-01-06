import java.util.Scanner;


public class Day1 {
	public static void main(String[] args) {
		int n = 0;
		int p = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = sc.nextInt();
		
		int min = p < (n-p) ? p : n-p;
		
		System.out.println((min)/2);
	}
}
