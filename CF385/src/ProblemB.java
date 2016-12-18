import java.util.Scanner;


public class ProblemB {
	static int n, m;
	static char[][] matrix;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		matrix = new char[n][m];
		
		int minX = -1, maxX = -1, minY = -1, maxY = -1;
		
//		System.out.println(n + " " + m);
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
//			System.out.println("input = " + input);
			for (int j = 0; j < input.length(); j++) {
				matrix[i][j] = input.charAt(j);
				if (input.charAt(j) == 'X') {
					if (i < minX || minX == -1) {
						minX = i;
					}
					if (i > maxX) {
						maxX = i;
					}
					
					if (j < minY || minY == -1) {
						minY = j;
					}
					
					if (j > maxY) {
						maxY = j;
					}
				}
			}
		}
		
		if (minX == -1 || minY == -1 || maxX == -1 || maxY == -1) {
			System.out.println("NO");
			return;
		} 
		
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (matrix[i][j] != 'X') {
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
		
	}
}
