import java.util.Arrays;

public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int idx1 = 0;
		int idx2 = 0;
		int idx = 0;
		int[] newInt = new int[m + n];
		while (idx < m + n) {
//			System.out.println("idx = " + idx);
			if (idx1 >= m) {
				newInt[idx] = nums2[idx2];
				idx++;
				idx2++;
			}

			else if (idx2 >= n) {
				newInt[idx] = nums1[idx1];
				idx++;
				idx1++;
			} else if (nums1[idx1] > nums2[idx2]) {
//				System.out.println("Greater");
				newInt[idx] = nums2[idx2];
				idx++;
				idx2++;

			} else if (nums1[idx1] <= nums2[idx2]) {
				newInt[idx] = nums1[idx1];
				idx++;
				idx1++;
			} else {
				System.out.println("Nothing");
			}

		}
		for (int i = 0; i < m + n; i++) {
			nums1[i] = newInt[i];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 0, 1, 2, 5, 6, 0, 0 };
		int[] nums2 = new int[] { 3, 4 };

		new Solution().merge(nums1, 5, nums2, 2);
		System.out.println(Arrays.toString(nums1));
	}
}
