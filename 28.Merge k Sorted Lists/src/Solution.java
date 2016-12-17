import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		for (ListNode list: lists) {
			if (list != null) {
				pqueue.offer(list);
			}
		}
		
		while (!pqueue.isEmpty()) {
			ListNode n = pqueue.poll();
			p.next = n;
			p = p.next;
			
			if (n.next != null) {
				pqueue.offer(n.next);
			}
		}
		
		return head.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		
		l1.next = l2;
		l2.next = l7;
		
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l8;
		
		ListNode node = new Solution().mergeKLists(new ListNode[]{l1, l3});
		
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}