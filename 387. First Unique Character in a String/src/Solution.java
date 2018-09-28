class Solution {
	// First Solution
//    public int firstUniqChar(String s) {
//        boolean[] isChecked = new boolean[s.length()];
//        for (int idx = 0; idx < s.length(); idx++) {
//        	if (isChecked[idx]) {
//        		continue;
//        	}
//        	boolean isDuplicate = false;
//        	char c = s.charAt(idx);
//        	isChecked[idx] = true;
//        
//        	for (int sIdx = idx + 1; sIdx < s.length(); sIdx ++) {
//        		if (isChecked[sIdx]) {
//            		continue;
//            	}
//        		char nextChar = s.charAt(sIdx);
//        		if (nextChar == c) {
//        			isChecked[sIdx] = true;
//        			isDuplicate = true;
//        		}
//        	}
//        	if (!isDuplicate) {
//        		return idx;
//        	}
//        }
//        return -1;
//    }
    
	// Second Solution
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int idx = 0; idx < s.length(); idx++) {
        	char c = s.charAt(idx);
        	freq[c - 'a'] += 1;
        }
        for (int idx = 0; idx < s.length(); idx++) {
        	char c = s.charAt(idx);
        	if (freq[c - 'a'] == 1) {
        		return idx;
        	}
        }
        return -1;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().firstUniqChar("leetcode"));
		System.out.println(new Solution().firstUniqChar("loveleetcode"));

	}
}