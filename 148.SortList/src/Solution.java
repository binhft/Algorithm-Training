import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return head;
		}

		List<Integer> list = new ArrayList<Integer>();

		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		Collections.sort(list);

		ListNode newHead = new ListNode(0);

		ListNode curr = newHead;

		for (Integer i : list) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}

		return newHead.next;
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

		ListNode res = new Solution().sortList(n2);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}

}
