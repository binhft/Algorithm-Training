package Problem2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int[][] crate = new int[c][2];
		for (int crate_i = 0; crate_i < c; crate_i++) {
			for (int crate_j = 0; crate_j < 2; crate_j++) {
				crate[crate_i][crate_j] = in.nextInt();
			}
		}

		Arrays.sort(crate, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] > o2[1]) {
					return -1;
				} else if (o1[1] == o2[1]) {
					return 0;
				}
				return 1;
			}

		});

//		for (int i = 0; i < c; i++) {
//			System.out.println(crate[i][0] + " " + crate[i][1]);
//		}
		int res = 0;
		int currentIndex = 0;
		while (n > 0 && currentIndex < c) {
			int[] checkVal = crate[currentIndex];
			int num = Math.min(checkVal[0], n);

//			System.out.println(num);
			res += num * checkVal[1];
			n -= num;
			currentIndex += 1;
		}

		System.out.println(res);
	}
}
