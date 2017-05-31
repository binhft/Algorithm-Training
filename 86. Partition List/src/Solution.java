public class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode fakeLess = new ListNode(0);
		ListNode tempLess = fakeLess;
		
		ListNode fakeEqual = new ListNode(0);
		ListNode tempEqual = fakeEqual;

		while (head != null) {
			if (head.val < x) {
				// System.out.println("Less " + head.val);
				fakeLess.next = new ListNode(head.val);
				fakeLess = fakeLess.next;

			} else {
				// System.out.println("Equal " + head.val);
				fakeEqual.next = new ListNode(head.val);
				fakeEqual = fakeEqual.next;
			}
			head = head.next;
		}
		// while (fakeEqual != null) {
		// System.out.print(fakeEqual.val + "->");
		// fakeEqual = fakeEqual.next;
		// }
		fakeLess.next = tempEqual.next;

		return tempLess.next;

	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n4 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n21 = new ListNode(2);

		// n1.next = n4;
		n2.next = n1;
		// n3.next = n2;
		// n2.next = n5;
		// n5.next = n21;

		ListNode res = new Solution().partition(n2, 1);

		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}
