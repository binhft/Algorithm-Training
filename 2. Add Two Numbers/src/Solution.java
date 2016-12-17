import java.util.ArrayList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(0);
		ListNode current = head;
		
		int reminder = 0;
		while (l1 != null || l2 != null) {
			int r1 = 0;
			int r2 = 0;
			if (l1 != null) {
				r1 = l1.val;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				r2 = l2.val;
				l2 = l2.next;
			}
			
			int res = r1 + r2 + reminder;
			ListNode tempNode = new ListNode(res%10);
			reminder = res/10;
			current.next = tempNode;
			current = current.next;
		}
		
		while (reminder != 0) {
			
			ListNode tempNode = new ListNode(reminder%10);
			reminder = reminder/10;
			current.next = tempNode;
			current = current.next;
		}
		return head.next;
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


