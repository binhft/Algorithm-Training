import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	void solveUtil(int board[][], Set<Integer> col, Set<Integer> row, int rowNum, int currentSum,
			ArrayList<Integer> res) {
		if (row.size() == board.length) {
//			System.out.println(row);
//			System.out.println(col);
//			System.out.println(currentSum);

			res.add(currentSum);
		}
		for (int i = rowNum; i < board.length; i++) {
			Set<Integer> rowCopy = new HashSet<Integer>(row);
			rowCopy.add(i);
			for (int j = 0; j < board[0].length; j++) {
				if (!col.contains(j)) {
					Set<Integer> colCopy = new HashSet<Integer>(col);
					colCopy.add(j);
					solveUtil(board, colCopy, rowCopy, rowNum + 1, currentSum + board[i][j], res);
				}
			}
		}
	}

	int maximumHarmonyScore(int[][] harmonyScores) {
		Set<Integer> col = new HashSet<Integer>();
		Set<Integer> row = new HashSet<Integer>();

		ArrayList<Integer> res = new ArrayList<Integer>();
		solveUtil(harmonyScores, col, row, 0, 0, res);
//		System.out.println(res);
		int max = 0;
		for (int i = 0; i < res.size(); i++) {
			max = Math.max(max, res.get(i));
		}
		return max;

	}

	public static void main(String[] args) {
//		System.out.println(new Solution().maximumHarmonyScore(new int[][] { { 2, 5 }, { 1, 3 } }));
		System.out.println(new Solution().maximumHarmonyScore(new int[][] { { 2, 2, 2 }, { 5, 4, 3 }, { 3, 1, 2 } }));

	}
}
