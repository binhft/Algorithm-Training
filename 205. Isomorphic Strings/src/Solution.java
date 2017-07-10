import java.util.HashMap;

public class Solution {
	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		} 
		if (s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashMap<Character, Character> mapReverse = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (map.containsKey(c1)) {
				if (map.get(c1) != c2) {
					return false;
				}
			} else {
				map.put(c1, c2);
			}
			
			if (mapReverse.containsKey(c2)) {
				if (mapReverse.get(c2) != c1) {
					return false;
				}
			} else {
				mapReverse.put(c2, c1);
			}
		}
		return true;
	}
}
