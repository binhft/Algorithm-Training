import java.util.HashMap;
import java.util.Hashtable;

public class LRUCache {
	class LinkNode {
		int key;
		int value;
		LinkNode pre;
		LinkNode post;
	}

	private void addNode(LinkNode node) {
		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	private void removeNode(LinkNode node) {
		LinkNode preNode = node.pre;
		LinkNode postNode = node.post;
		preNode.post = postNode;
		postNode.pre = preNode;
	}

	private void moveToHead(LinkNode node) {
		this.removeNode(node);
		this.addNode(node);
	}

	private LinkNode popTail() {
		LinkNode res = tail.pre;
		this.removeNode(res);
		return res;
	}

	private Hashtable<Integer, LinkNode> cache = new Hashtable<Integer, LinkNode>();
	private int count;
	private int capacity;
	private LinkNode head, tail;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new LinkNode();
		head.pre = null;

		tail = new LinkNode();
		tail.post = null;

		tail.pre = head;
		head.post = tail;
	}

	public int get(int key) {
		LinkNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		this.moveToHead(node);
		return node.value;
	}

	public void set(int key, int value) {
		LinkNode node = cache.get(key);

		if (node == null) {
			LinkNode newNode = new LinkNode();
			newNode.value = value;
			newNode.key = key;

			this.cache.put(key, newNode);
			this.addNode(newNode);

			++count;

			if (count > capacity) {
				LinkNode tail = this.popTail();
				this.cache.remove(tail.key);
				--count;
			}
		} else {
			node.value = value;
			this.moveToHead(node);
		}
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(1);
		lru.set(2, 1);
		System.out.println(lru.get(2));
		lru.set(3, 2);
		System.out.println(lru.get(2));
	}
}