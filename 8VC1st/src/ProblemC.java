import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();

		int[] input = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			input[i] = i;
		}
		for (int i = 1; i <= num; i++) {
			int relative = sc.nextInt();
			for (int j = 1; j <= num; j++) {
				if (input[j] == input[i]) {
					input[j] = input[relative];
				}
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= num; i++) {
			set.add(input[i]);
		}
		// int[][] input = new int[num + 1][num + 1];

		// for (int i = 1; i <= num; i++) {
		// int relative = sc.nextInt();
		// input[i][relative] = 1;
		// input[relative][i] = 1;
		// }
		//
		// int count = 0;
		// boolean[] visited = new boolean[num + 1];
		// for (int i = 1; i <= num; i++) {
		// if (!visited[i]) {
		// count++;
		// visited[i] = true;
		// Queue<Integer> queue = new LinkedList<Integer>();
		// queue.add(i);
		//
		// while (!queue.isEmpty()) {
		// int item = queue.poll();
		// for (int j = 1; j <= num; j++) {
		// if (input[j][item] == 1 && !visited[j]) {
		// visited[j] = true;
		// queue.add(j);
		// }
		// }
		// }
		// }
		// }

		System.out.println(set.size());

	}
}
