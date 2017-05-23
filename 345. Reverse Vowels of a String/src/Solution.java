public class Solution {
	public String reverseVowels(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		char[] cList = s.toCharArray();

		int low = 0;
		int high = cList.length - 1;

		String vowels = "ueoaiUEOAI";

		while (low <= high) {
			while (low <= high && vowels.indexOf(cList[low]) < 0) {
				low++;
			}

			while (low <= high && vowels.indexOf(cList[high]) < 0) {
				high--;
			}

			if (low <= high) {
				char temp = cList[low];
				cList[low] = cList[high];
				cList[high] = temp;
				low++;
				high--;
			}
		}
		
		return new String(cList);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverseVowels("hello"));
	}
}
