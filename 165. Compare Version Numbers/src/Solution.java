import java.util.Arrays;

public class Solution {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
//		System.out.println(Arrays.toString(v1));

		int start = 0;
		int max = Math.max(v1.length, v2.length);
		int min = Math.min(v1.length, v2.length);
		while (start < max) {
			int num1 = 0;
			int num2 = 0;

			if (start >= v1.length) {
				num1 = 0;
			} else {
				num1 = Integer.parseInt(v1[start]);
			}
			if (start >= v2.length) {
				num2 = 0;
			} else {
				num2 = Integer.parseInt(v2[start]);
			}

//			System.out.println(num1 + " " + num2);
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			}
			start++;
		}

		return 0;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.compareVersion("1.2.2", "1.2.1"));
	}
}
