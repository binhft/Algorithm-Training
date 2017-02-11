public class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		if (B >= H || F >= D || A >= G || E >= C) {
			return area1 + area2;
		}

		int x1 = Math.max(A, E);
		int y1 = Math.max(B, F);
		int x2 = Math.min(C, G);
		int y2 = Math.min(D, H);

		int distance = (x1 - x2) * (y1 - y2);
		return area1 + area2 - distance;

	}

	public static void main(String[] args) {

	}
}
