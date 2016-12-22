/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0 || head == null) {
			return head;
		}
		int len = 0;
		ListNode temp = head;
		ListNode last = head;
		while (temp != null) {
			temp = temp.next;
			if (temp != null) {
				last = temp;
			}
			len += 1;
		}
		System.out.println("Length = " + len);
		k = k % len;
		
		if (k == 0) {
			return head;
		}

		temp = head;
		int count = 1;
		while (count < len - k) {
			count++;
			temp = temp.next;
		}
		ListNode first = temp.next;
		temp.next = null;
		last.next = head;

		return first;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		 l1.next = l2;
		l2.next = l3;
//		l3.next = l4;

		ListNode res = new Solution().rotateRight(l1, 1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}