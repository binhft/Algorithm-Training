
public class Solution2 {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode p = reverseList(head.next);
		head.next.next = p;
		head.next = null;
		return p;
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
