public class Solution {
	static int search(int m, int c, int[][] graph, int[][] status) {
		if (status[m][c] != -1) {
			return status[m][c];
		}
		if (m == c) {
			status[m][c] = 2;
			return status[m][c];
		}
		if (m == 0) {
			status[m][c] = 1;
			return status[m][c];
		}
		status[m][c] = 0;
		boolean all_cat_win = true;
		for (int next_m : graph[m]) {
			if (next_m != c) {
				boolean all_m_win = true;
				boolean exist_cat_win = false;
				for (int next_c : graph[c]) {
					if (next_c != 0) {
						int next_status = search(next_m, next_c, graph, status);
						if (next_status != 1) {
							all_m_win = false;
							if (next_status == 2) {
								exist_cat_win = true;
							}
						}
						if (!all_m_win && exist_cat_win) {
							break;
						}
					}

				}
				if (all_m_win) {
					status[m][c] = 1;
					return status[m][c];
				}
				if (!exist_cat_win) {
					all_cat_win = false;
				}

			}
		}
		if (all_cat_win) {
			status[m][c] = 2;
		}
		return status[m][c];
	}

	public int catMouseGame(int[][] graph) {
		int n = graph.length + 1;
		int[][] status = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				status[i][j] = -1;
			}
		}
		return search(1, 2, graph, status);
	}

	public static void main(String[] args) {
		int[][] path = new int[6][6];
		path[0] = new int[] { 2, 5 };
		path[1] = new int[] { 3 };
		path[2] = new int[] { 0, 4, 5 };
		path[3] = new int[] { 1, 4, 5 };
		path[4] = new int[] { 2, 3 };
		path[5] = new int[] { 0, 2, 3 };
		System.out.println(new Solution().catMouseGame(path));
	}
}
