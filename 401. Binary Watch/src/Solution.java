import java.util.ArrayList;
import java.util.List;

public class Solution {
//	// brute force
//	public List<String> readBinaryWatch(int num) {
//		List<String> res = new ArrayList<String>();
//		for (int i = 0; i <= num; i++) {
//			int left = i;
//			int right = num - i;
//			for (int hour = 0; hour < 12; hour++) {
//				if (Integer.bitCount(hour) == left) {
//					for (int min = 0; min < 60; min++) {
//						if (Integer.bitCount(min) == right) {
//							String h = "" + hour;
//							String m = "" + min;
//							if (min < 10) {
//								m = "0" + min;
//							}
//							res.add(h + ":" + m);
//						}
//					}
//				}
//			}
//
//		}
//		return res;
//	}
	
	// brute force
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i <= num; i++) {
			int left = i;
			int right = num - i;
			for (int hour = 0; hour < 12; hour++) {
				if (Integer.bitCount(hour) == left) {
					for (int min = 0; min < 60; min++) {
						if (Integer.bitCount(min) == right) {
							String h = "" + hour;
							String m = "" + min;
							if (min < 10) {
								m = "0" + min;
							}
							res.add(h + ":" + m);
						}
					}
				}
			}
			
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> res = new Solution().readBinaryWatch(1);
		for (String val: res) {
			System.out.println(val);
		}
	}
}
