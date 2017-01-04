import java.util.Stack;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode first = head;
		while (first != null) {
			stack.push(first);
			first = first.next;
		}
		first = head;
		while (first != null) {
			ListNode compareNode = stack.pop();
			if (compareNode.val != first.val) {
				return false;
			}
			first = first.next;
		}
		return true;
	}
}