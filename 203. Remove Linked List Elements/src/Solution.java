public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode currHead = new ListNode(0);
		ListNode newHead = currHead;
		while (head != null) {
//			System.out.print(head.val + "->");

			if (head.val != val) {
				currHead.next = head;

				currHead = currHead.next;
			} else {

				currHead.next = null;
			}
			head = head.next;

		}
		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(1);
		ListNode n13 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n11;
		n11.next = n3;
		n3.next = n13;

		ListNode res = new Solution().removeElements(n1, 1);
		System.out.println("");
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
