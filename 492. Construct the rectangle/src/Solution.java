public class Solution {
	public int[] constructRectangle(int area) {
		int res[] = new int[2];
		if (area == 0) {
			return res;
		}
		
		int check_point = (int) Math.sqrt(area);
		for (int i = check_point; i >= 1; i--) {
			if (area % i == 0) {
				res[1] = i;
				res[0] = area/i;
				break;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] res = new Solution().constructRectangle(0);
		for (int i: res) {
			System.out.println(i);
		}
	}
}
