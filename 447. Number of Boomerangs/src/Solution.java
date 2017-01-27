import java.util.ArrayList;
import java.util.Hashtable;

public class Solution {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		if (points == null) {
			return res;
		}

		for (int i = 0; i < points.length; i++) {
			Hashtable<Double, ArrayList<Integer>> distance = new Hashtable<Double, ArrayList<Integer>>();
			for (int j = 0; j < points.length; j++) {
				if (j == i) continue;
				double val = distance(points[i], points[j]);
//				System.out.println(val);
				if (distance.containsKey(val)) {
					ArrayList<Integer> arr  = distance.get(val);
					arr.add(j);
					distance.put(val, arr);
				} else {
					ArrayList<Integer> arr = new ArrayList<Integer>();
					arr.add(j);
					distance.put(val, arr);
				}
			}

			for (ArrayList<Integer> check : distance.values()) {
				int size = check.size();
//				System.out.println(size);
				if (size > 1) {
					res += size * (size - 1);
				}
			}
		}

		return res;
	}

	private double distance(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] {
				{0, 0},
				{1, 0},
				{2, 0}
		};
		System.out.println(new Solution().numberOfBoomerangs(arr));
	}
}
