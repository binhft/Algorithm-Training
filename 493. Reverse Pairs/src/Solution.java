import java.util.Arrays;

public class Solution {
	// class Node {
	// int val, less = 0, count = 1;
	// Node left, right;
	//
	// public Node(int v) {
	// this.val = v;
	// }
	// }

	// private void search(int[] cnt, Node node, double target) {
	// if (node == null)
	// return;
	// else if (target == node.val)
	// cnt[0] += node.less;
	// else if (target < node.val)
	// search(cnt, node.left, target);
	// else {
	// cnt[0] += node.less + node.count;
	// search(cnt, node.right, target);
	// }
	// }

	// private int search(Node node, double target) {
	// int res = 0;
	// while (node != null) {
	// if (node.val == target) {
	// res += node.less;
	// node = null;
	// } else if (target < node.val) {
	// node = node.left;
	// } else {
	// res += node.less + node.count;
	// node = node.right;
	// }
	// }
	//
	// return res;
	// }

	// private Node build(int val, Node n) {
	// if (n == null) {
	// return new Node(val);
	// }
	//
	// if (val == n.val) {
	// n.count += 1;
	// } else if (val > n.val) {
	// n.right = build(val, n.right);
	// } else {
	// n.less += 1;
	// n.left = build(val, n.left);
	// }
	// return n;
	// }

	// private Node build(int val, Node root) {
	// if (root == null) {
	// root = new Node(val);
	// return root;
	// }
	// Node head = root;
	// while (true) {
	// if (head.val == val) {
	// head.count += 1;
	// break;
	// } else if (head.val < val) {
	// if (head.right == null) {
	// head.right = new Node(val);
	// break;
	// } else {
	// head = head.right;
	// }
	// } else {
	// head.less += 1;
	// if (head.left == null) {
	// head.left = new Node(val);
	// break;
	// } else {
	// head = head.left;
	// }
	// }
	// }
	// return root;
	// }
	private int res;

	private void mergeSort(int[] nums, int low, int high) {
		if (low >= high) {
			return;
		}

		int mid = low + (high - low) / 2;
		mergeSort(nums, low, mid);
		mergeSort(nums, mid + 1, high);

		int count = 0;
		for (int l = low, r = mid + 1; l < mid + 1;) {
			if (r > high || (long) nums[l] <= 2 * (long) nums[r]) {
				res += count;
				l++;
			} else {
				r++;
				count++;
			}
		}

		Arrays.sort(nums, low, high + 1);

	}

	public int reversePairs(int[] nums) {
		res = 0;
		mergeSort(nums, 0, nums.length - 1);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reversePairs(new int[] { 2, 4, 3, 5,
				1 }));
		System.out.println(new Solution().reversePairs(new int[] { 1, 3, 2, 3,
				1 }));
	}
}
