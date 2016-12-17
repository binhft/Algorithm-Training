/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */


public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode temp = current.next;

			current.next = prev;
			prev = current;
			current = temp;
		}

		return prev;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);

		l1.next = l2;
		l2.next = l3;

		ListNode reverseList = new Solution().reverseList(l1);

		while (reverseList != null) {
			System.out.println(reverseList.val);
			reverseList = reverseList.next;
		}
	}
}