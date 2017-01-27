package Problem1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long xTreasure = in.nextLong();
		long yTreasure = in.nextLong();
		int n = in.nextInt();
		long[][] direction = new long[n][2];
		for (int direction_i = 0; direction_i < n; direction_i++) {
			for (int direction_j = 0; direction_j < 2; direction_j++) {
				direction[direction_i][direction_j] = in.nextLong();
			}
		}
		long xHome = xTreasure;
		long yHome = yTreasure;
		for (int i = 0; i < n; i++) {
			xHome -= direction[i][0];
			yHome -= direction[i][1];
		}
		
		System.out.println(xHome + " " + yHome);
	}
}
