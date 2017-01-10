public class Solution {
//	public boolean isPerfectSquare(int num) {
//		if (num == 0 || num == 1) {
//			return true;
//		}
//		int low = 0;
//		int high = num;
//		while (low < high) {
////			System.out.println(low + " " + high);
//			int mid = low + (high - low)/2;
//			
//			if (mid < num/mid) {
//				low = mid + 1;
//			} else {
//				high = mid;
//			}
//		}
//		
//		if (low * low == num) {
//			return true;
//		}
//		return false;
//	}
	
	public boolean isPerfectSquare(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		
		return num == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().isPerfectSquare(4));
	}
}
