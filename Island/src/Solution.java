import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	boolean isSafe(int M[][], int row, int col, boolean visited[][], int numRow, int numCol) {
		// row number is in range, column number is in range
		// and value is 1 and not yet visited
		return (row >= 0) && (row < numRow) && (col >= 0) && (col < numCol) && (M[row][col] == 1 && !visited[row][col]);
	}

	void DFS(int M[][], int row, int col, boolean visited[][], int numRow, int numCol) {
		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int rowNbr[] = new int[] { -1, 0, 0, 1 };
		int colNbr[] = new int[] { 0, -1, 1, 0 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 4; ++k) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, numRow, numCol)) {
				DFS(M, row + rowNbr[k], col + colNbr[k], visited, numRow, numCol);
			}
		}

	}

	boolean isConnected(int[][] map, int nRow, int nCol) {
		boolean visited[][] = new boolean[nRow][nCol];
		int numGraph = 0;
		for (int i = 0; i < nRow; ++i)
			for (int j = 0; j < nCol; ++j) {
				if (map[i][j] == 1 && !visited[i][j]) {
					numGraph += 1;
					DFS(map, i, j, visited, nRow, nCol);
				}
				if (numGraph > 1) {
					return false;
				}
			}
		return true;
	}

	int bestCost = Integer.MAX_VALUE;

	int[][] deepCopy(int[][] original) {
		if (original == null) {
			return null;
		}

		final int[][] result = new int[original.length][];
		for (int i = 0; i < original.length; i++) {
			result[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return result;
	}

	void findBestBridges(int[][] map, int nBridged, int minX, int minY) {
		int nRow = map.length;
		int nCol = map[0].length;

		if (minX < 0 || minY < 0 || minX >= nRow || minY >= nCol) {
			return;
		}

		if (isConnected(map, nRow, nCol)) {
			if (nBridged < bestCost) {
				bestCost = nBridged;
			}
			return;
		}

		if (nBridged > bestCost || nBridged > nRow + nCol) {
			return;
		}

		for (int i = minX; i < map.length; i++) {
			for (int j = minY; j < map[0].length; j++) {
				if (map[i][j] == 0) {
					int[][] newMap = deepCopy(map);
					newMap[i][j] = 1;
					findBestBridges(newMap, nBridged + 1, i, j);
					findBestBridges(newMap, nBridged + 1, i - 1, j + 1);
					findBestBridges(newMap, nBridged + 1, i + 1, j - 1);
				}
			}
		}
	}

	int bridgesCost(String[] nationalMap) {
		int nRow = nationalMap[0].length();
		int nCol = nationalMap.length;
		int[][] map = new int[nRow][nationalMap.length];
		for (int col = 0; col < nationalMap.length; col++) {
			for (int row = 0; row < nRow; row++) {
				map[row][col] = nationalMap[col].charAt(row) - '0';
			}
		}
		findBestBridges(map, 0, 0, 0);
		return bestCost;
	}

	public static void main(String[] args) {
//		System.out.println(
//				new Solution().bridgesCost(new String[] { "11000", "11000", "00100", "00010", "00111", "00111" }));
//		System.out.println(new Solution().bridgesCost(new String[] { "1001", "0000", "0010", "0000", "0101" }));
		System.out.println(new Solution().bridgesCost(new String[] { "10000", "01010", "00100", "01001", "10010" }));

	}

}
