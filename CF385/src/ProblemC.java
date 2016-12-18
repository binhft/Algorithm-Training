import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemC {
	static int n;
	static int m;
	static int k;
	static int[] cities;
	static boolean[] isGov;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();

		List<Integer> hq = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			int headquater = sc.nextInt();
			hq.add(headquater);
		}
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		for (int i = 0; i < n + 1; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		List<Integer> numbers = new ArrayList<Integer>();
		List<Boolean> flags = new ArrayList<Boolean>();
		for (int i = 0; i < n + 1; i++) {
			numbers.add(1);
			flags.add(false);
		}

		for (int i = 0; i < k; i++) {
			int hqAct = hq.get(i);
			dfs(hqAct, hqAct, adj, flags, numbers);
		}

		int maxNum = 0;
		int maxInd = 0;
		int res = n;

		for (int i = 0; i < k; i++) {
			int actHq = hq.get(i);
			if (numbers.get(actHq) > maxNum) {
				maxNum = numbers.get(actHq);
				maxInd = actHq;
			}

			res -= numbers.get(actHq);
		}

		numbers.set(maxInd, maxNum + res);

		int ans = 0;
		for (int i = 0; i < k; i++) {
			int act_real = hq.get(i);
			ans += (numbers.get(act_real) * (numbers.get(act_real) - 1) / 2);
		}

		ans -= m;
		System.out.println(ans);
	}

	private static void dfs(int start, int act, List<List<Integer>> list,
			List<Boolean> flag, List<Integer> sum) {
		flag.set(act, true);
		for (int j = 0; j < list.get(act).size(); j++) {
			int act2 = list.get(act).get(j);
			if (!flag.get(act2)) {
				dfs(start, act2, list, flag, sum);
				sum.set(start, sum.get(start) + 1);
			}
		}
	}
}
