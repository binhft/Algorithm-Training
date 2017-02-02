import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// int[][] edges = new int[n + 1][n + 1];
		int[] colors = new int[n + 1];
		// boolean[] visited = new boolean[n + 1];

		ArrayList<ArrayList<Integer>> edgeArr = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			edgeArr.add(new ArrayList<Integer>());
		}
		for (int i = 1; i <= n - 1; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			// edges[j][k] = 1;
			// edges[k][j] = 1;

			edgeArr.get(j - 1).add(k);
			edgeArr.get(k - 1).add(j);
		}
		for (int i = 1; i <= n; i++) {
			colors[i] = sc.nextInt();
		}
		ArrayList<Integer> diff1 = new ArrayList<Integer>();
		ArrayList<Integer> diff2 = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			int diff = 0;
			// for (int j = 1; j <= n; j++) {
			// if (edges[i][j] == 1 && colors[i] != colors[j]) {
			// diff++;
			// }
			// }
			ArrayList<Integer> checkEdge = edgeArr.get(i - 1);
			for (int j : checkEdge) {
				if (colors[i] != colors[j]) {
					diff++;
				}
			}

			if (diff >= 2) {
				diff2.add(i);
			} else if (diff == 1) {
				diff1.add(i);
			}
		}

		if (diff2.size() > 1) {
			System.out.println("NO");
			return;
		} else if (diff2.size() == 1) {
			int removeItem = diff2.get(0);
			int total1 = diff1.size();
			for (int i = total1 - 1; i >= 0; i--) {
				int item = diff1.get(i);
				if (edgeArr.get(item - 1).contains(removeItem)
						&& colors[removeItem] != colors[item]) {
					diff1.remove(i);
				}
			}
			if (diff1.size() >= 1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				System.out.println(removeItem);
			}
		} else if (diff1.size() > 2) {
			System.out.println("NO");
			return;
		} else if (diff1.size() == 1) {
			System.out.println("YES");
			System.out.println(diff1.get(0));
			return;
		} else if (diff1.size() == 2) {
			int first = diff1.get(0);
			int second = diff1.get(1);
			if (edgeArr.get(first-1).contains(second) && colors[first] != colors[second]) {
				System.out.println("YES");
				System.out.println(first);
			} else {
				System.out.println("NO");
			}
			return;
		} else {
			System.out.println("YES");
			System.out.println(1);
		}
	}
}
