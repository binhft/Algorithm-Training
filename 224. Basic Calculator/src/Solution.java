import java.util.Stack;

public class Solution {
	public int calculate(String s) {
		int result = 0;
		int sign = 1;
		int number = 0;
		Stack<Integer> stack = new Stack<Integer>();
		if (s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')') {
			s = "(" + s + ")";
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = number * 10 + (c - '0');
			} else if (c == '+') {
				result += number * sign;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				result += number * sign;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (c == ')') {
				result += sign * number;
				number = 0;
				result *= stack.pop();
				result += stack.pop();
			}
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(new Solution().calculate("(3)+1"));
	}
}
