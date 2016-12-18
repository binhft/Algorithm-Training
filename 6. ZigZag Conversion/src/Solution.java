public class Solution {
	public String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sbList = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++) {
			sbList[i] = new StringBuffer();
		}
		
		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < numRows && i < len; idx++) {
				sbList[idx].append(c[i++]);
			}
			
			for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
				sbList[idx].append(c[i++]);
			}
		}
		
		for (int j = 1; j < numRows; j++) {
			sbList[0].append(sbList[j]);
		}
		
		return sbList[0].toString();
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().convert("A", 3));
	}
}
