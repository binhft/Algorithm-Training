public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode res = head;
		head = head.next;
		res.next = null;

		while (head != null) {
			ListNode start = res;

			if (head.val < res.val) {
//				System.out.println("1111 " + head.val);
				ListNode temp = head;
				head = head.next;
				temp.next = res;
				res = temp;

			} else {
//				System.out.println("2222 " + head.val);
				while (start.next != null && start.next.val < head.val) {
					start = start.next;
				}
//				System.out.println("Start = " + start.val);

				ListNode temp = head;
				head = head.next;

				temp.next = start.next;
				start.next = temp;

			}

		}

		return res;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n2.next = n1;
		n1.next = n5;
		n5.next = n4;
		n4.next = n3;

		ListNode res = new Solution().insertionSortList(n2);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}
