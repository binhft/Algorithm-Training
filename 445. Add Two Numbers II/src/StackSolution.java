import java.util.Stack;


public class StackSolution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		
		int sum = 0;
		ListNode list = new ListNode(0);
		
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (!s1.isEmpty()) sum += s1.pop();
			if (!s2.isEmpty()) sum += s2.pop();
			
			list.val = sum%10;
			ListNode head = new ListNode(sum/10);
			head.next = list;
			list = head;
			sum /= 10;
		}
		
		return list.val == 0 ? list.next : list;
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
