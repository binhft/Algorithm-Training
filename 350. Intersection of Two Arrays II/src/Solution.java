import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0
				|| nums2.length == 0) {
			return new int[0];
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int idx1 = 0;
		int idx2 = 0;

		List<Integer> list = new ArrayList<Integer>();

		while (idx1 < nums1.length && idx2 < nums2.length) {
			if (nums1[idx1] == nums2[idx2]) {
				list.add(nums1[idx1]);
				idx1++;
				idx2++;
			} else if (nums1[idx1] > nums2[idx2]) {
				idx2++;
			} else {
				idx1++;
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] n1 = new int[] { 1, 2, 2, 1 };
		int[] n2 = new int[] { 2, 2, 1 };

		int[] res = new Solution().intersect(n1, n2);
		System.out.println(Arrays.toString(res));
	}
}
