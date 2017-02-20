public class Solution {
	public int findMinMoves(int[] machines) {
		int sum = 0;
		int len = machines.length;

		for (int i = 0; i < len; i++) {
			sum += machines[i];
		}

		if (sum % len != 0) {
			return -1;
		}

		int target = sum / len;

		int[] move = new int[len];
		for (int i = 0; i < len - 1; i++) {
			if (machines[i] > target) {
				move[i] += machines[i] - target;
				machines[i + 1] += machines[i] - target;
				machines[i] = target;
			} else {
				move[i + 1] = target - machines[i];
				machines[i + 1] -= target - machines[i];
				machines[i] = target;
			}
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, move[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMinMoves(new int[] { 0, 3, 0 }));
	}
}
