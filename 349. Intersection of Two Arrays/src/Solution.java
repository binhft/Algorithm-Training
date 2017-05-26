import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}

		int[] res = new int[set.size()];
		int idx = 0;
		for (int num : set) {
			res[idx] = num;
			idx++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 2, 1 };
		int[] nums2 = new int[] { 2, 2 };
		int[] res = new Solution().intersection(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}

}
