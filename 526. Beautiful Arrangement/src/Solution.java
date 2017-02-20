public class Solution {
	int res = 0;

	public int countArrangement(int N) {
		res = 0;
		boolean[] visited = new boolean[N + 1];
		dfs(N, visited, 1);
		return res;
	}

	private void dfs(int N, boolean[] visited, int pos) {
		if (pos > N) {
			res++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
				visited[i] = true;
				dfs(N, visited, pos + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countArrangement(2));
		System.out.println(s.countArrangement(3));
		System.out.println(s.countArrangement(4));
		System.out.println(s.countArrangement(5));
	}
}
