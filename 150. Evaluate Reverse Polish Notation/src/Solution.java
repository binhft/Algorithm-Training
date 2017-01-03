import java.util.Stack;

public class Solution {
	public int evalRPN(String[] tokens) {
		int returnValue = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();
		for (String token : tokens) {
			if (operators.indexOf(token) < 0) {
				stack.push(token);
			} else {
				Integer a = Integer.valueOf(stack.pop());
				Integer b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(token);
				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(b / a));
					break;
				default:
					break;
				}
			}
		}

		returnValue = Integer.valueOf(stack.pop());

		return returnValue;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().evalRPN(new String[] {"2", "1", "+", "3", "*"}));
	}
}
