import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int findBlackPixel(char[][] picture, int N) {
		if (picture == null || picture.length == 0 || picture[0].length == 0) {
			return 0;
		}

		int numRow = picture.length;
		int numCol = picture[0].length;

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < numRow; i++) {
			String check = checkRow(picture, i, N);
			if (check.length() > 0) {
				map.put(check, map.getOrDefault(check, 0) + 1);
			}
		}
		int res = 0;
		for (String key : map.keySet()) {
			if (map.get(key) == N) {
				for (int j = 0; j < numCol; j++) {
					if (key.charAt(j) == 'B' && checkCol(picture, j) == N) {
						res += N;
					}
				}
			}
		}

		return res;
	}

	private String checkRow(char[][] picture, int idx, int target) {
		int nRow = 0;
		for (int k = 0; k < picture[0].length; k++) {
			if (picture[idx][k] == 'B') {
				nRow++;
			}
		}
		if (nRow == target) {
			return String.valueOf(picture[idx]);
		}
		return "";
	}

	private int checkCol(char[][] picture, int idx) {
		int nCol = 0;
		for (int k = 0; k < picture.length; k++) {
			if (picture[k][idx] == 'B') {
				nCol++;
			}
		}
		return nCol;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		// for (char c: "WWBWBWWWWBBWBWW".toCharArray()) {
		// System.out.print(c + "','");
		// }
		System.out.println(s.findBlackPixel(new char[][] {
				{ 'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B',
						'B', 'W', 'W' },
				{ 'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B',
						'B', 'W', 'W' },
				{ 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'B', 'W', 'B', 'W', 'W',
						'W', 'W', 'B' },
				{ 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W',
						'B', 'W', 'W' },
				{ 'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B',
						'B', 'W', 'W' },
				{ 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W',
						'B', 'W', 'W' },
				{ 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W',
						'B', 'W', 'W' },
				{ 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W',
						'B', 'W', 'W' },

		}, 5));
	}

}
