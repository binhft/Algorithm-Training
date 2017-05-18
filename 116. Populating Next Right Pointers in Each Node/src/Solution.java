import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		
		TreeLinkNode pre = null;
		int count = 1;
		while (!queue.isEmpty()) {
			count += 1;
			TreeLinkNode node = (TreeLinkNode) queue.remove();
			if (pre != null) {
				pre.next = node;
//				System.out.println("Grant next of " + pre.val + " to " + node.val);
			}
			if (count == (count & -count)) {
				pre = null;
			} else {
				pre = node;
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		
		new Solution().connect(n1);
	}
}
