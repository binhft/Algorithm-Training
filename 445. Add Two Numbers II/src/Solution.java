import java.util.ArrayList;

public class Solution {
	
	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode rl1 = reverseList(l1);
		ListNode rl2 = reverseList(l2);
		
		ListNode head = new ListNode(0);
		ListNode current = head;
		
		int reminder = 0;
		while (rl1 != null || rl2 != null) {
			int val1 = 0;
			int val2 = 0;
			if (rl1 != null) {
				val1 = rl1.val;
				rl1 = rl1.next;
			}
			if (rl2 != null) {
				val2 = rl2.val;
				rl2 = rl2.next;
			}
			
			int res = val1 + val2 + reminder;
			ListNode temp = new ListNode(res%10);
			current.next = temp;
			current = temp;
			reminder = res/10;
		}
		
		while (reminder > 0) {
			ListNode next = new ListNode(reminder%10);
			reminder = reminder/10;
			current.next = next;
			current = current.next;
		}
		return reverseList(head.next);
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l8 = new ListNode(8);
		l1.next = l8;
		
		ListNode res = new Solution().addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}


