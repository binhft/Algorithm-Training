import java.util.HashMap;
import java.util.Scanner;

public class ProblemD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		int res = 0;
		int numDouble = 0;
		for (Integer value: map.values()) {
			int check = value % 2;
			if (value % 2 == 1) {
				res += 1;
			} else if (value % 2 == 0) {
				numDouble += 1;
			}
		}
		
		res += numDouble - numDouble%2;
		System.out.println(res);

		
		
		

	}
}
