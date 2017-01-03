import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	class Node {
		public int count = 0;
		public LinkedHashSet<Integer> keys = null;
		public Node prev = null, next = null;

		public Node(int count) {
			super();
			this.count = count;
			prev = next = null;
			keys = new LinkedHashSet<Integer>();
		}
	}

	private HashMap<Integer, Integer> valueHash = null;
	private HashMap<Integer, Node> nodeHash = null;
	private int cap = 0;
	private Node head = null;

	public LFUCache(int capacity) {
		this.cap = capacity;
		valueHash = new HashMap<Integer, Integer>();
		nodeHash = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		if (valueHash.containsKey(key)) {
			increaseCount(key);
			return valueHash.get(key);
		}
		return -1;
	}

	public void set(int key, int value) {
		if (this.cap == 0) {
			return;
		}
		if (valueHash.containsKey(key)) {
			valueHash.put(key, value);
		} else {
			if (valueHash.size() < this.cap) {
				valueHash.put(key, value);
			} else {
				removeOld();
				valueHash.put(key, value);
			}
			addToHead(key);
		}

		increaseCount(key);
	}

	private void addToHead(int key) {
		if (head == null) {
			head = new Node(0);
			head.keys.add(key);
		} else if (head.count > 0) {
			Node node = new Node(0);
			node.keys.add(key);
			node.next = head;
			head.prev = node;
			head = node;
		} else {
			head.keys.add(key);
		}
		nodeHash.put(key, head);
	}

	private void increaseCount(int key) {
		Node node = nodeHash.get(key);
		node.keys.remove(key);

		if (node.next == null) {
			node.next = new Node(node.count + 1);
			node.next.keys.add(key);
			node.next.prev = node;
		} else if (node.next.count == (node.count + 1)) {
			node.next.keys.add(key);
		} else {
			Node temp = new Node(node.count + 1);
			temp.keys.add(key);
			node.next.prev = temp;
			temp.next = node.next;
			node.next = temp;
			temp.prev = node;

		}

		nodeHash.put(key, node.next);
		if (node.keys.size() == 0) {
			remove(node);
		}
	}

	private void removeOld() {
		if (head == null) {
			return;
		}
		int old = 0;
		for (int n : head.keys) {
			old = n;
			break;
		}
		head.keys.remove(old);
		if (head.keys.size() == 0) {
			remove(head);
		}
		valueHash.remove(old);
		nodeHash.remove(old);
	}

	private void remove(Node node) {
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	public static void main(String[] args) {
		LFUCache lru = new LFUCache(0);
		lru.set(0, 0);
		System.out.println(lru.get(0));
//		lru.set(3, 2);
//		System.out.println(lru.get(2));
	}
}
