public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		ListNode curr = head;
		ListNode pre = null;
		ListNode deleteNode = null;

		int count = 0;

		while (curr != null) {
			curr = curr.next;
			count += 1;
			if (count >= n) {
				pre = deleteNode;
				deleteNode = deleteNode == null ? head : deleteNode.next;
			}
		}
		if (pre != null) {
			pre.next = deleteNode.next;
		} else {
			head = head.next;
		}
		return head;

	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode res = new Solution().removeNthFromEnd(n1, 1);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}
