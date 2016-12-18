import java.util.Stack;

public class Solution {
	public String addStrings(String a, String b) {
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();
		
		for (int i = 0; i < a.length(); i++) {
			s1.push(a.charAt(i));
		}
		
		for (int i = 0; i < b.length(); i++) {
			s2.push(b.charAt(i));
		}
		
		Stack<Character> res = new Stack<Character>();
		int sum = 0;
		while (!s1.isEmpty() || !s2.isEmpty() || sum > 0) {
			if (!s1.isEmpty()) {
				sum += s1.pop() - '0';
			}
			
			if (!s2.isEmpty()) {
				sum += s2.pop() - '0';
			}
			
			res.push((char)(sum%10 + '0'));
			sum /= 10;
		}
		
		char[] c = new char[res.size()];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = res.pop();
		}
		
		return String.valueOf(c);
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().addStrings("55", "45"));
	}
}
