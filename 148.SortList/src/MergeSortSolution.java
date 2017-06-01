import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortSolution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode p1 = head;
		ListNode p2 = head;
		ListNode pre = head;

		while (p2 != null && p2.next != null) {
			pre = p1;
			p1 = p1.next;
			p2 = p2.next.next;

		}

		pre.next = null;
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(p1);

		return merge(h1, h2);
	}


	private ListNode merge(ListNode h1, ListNode h2) {
		if (h1 == null) {
			return h2;
		}

		if (h2 == null) {
			return h1;
		}

		if (h1.val < h2.val) {
			h1.next = merge(h1.next, h2);
			return h1;
		} else {
			h2.next = merge(h1, h2.next);
			return h2;
		}
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

		ListNode res = new MergeSortSolution().sortList(n2);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}

}
