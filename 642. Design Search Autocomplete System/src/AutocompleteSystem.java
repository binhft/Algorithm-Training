import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutocompleteSystem {
	class Node {

		public Node(String sentence, int times) {
			super();
			this.sentence = sentence;
			this.times = times;
		}

		String sentence;
		int times;
	}

	class Trie {
		int times;
		Trie[] branchs = new Trie[27];
	}

	private int getInt(char c) {
		return c == ' ' ? 26 : c - 'a';
	}

	Trie root;
	String cur_sen = "";

	private void insert(Trie t, String s, int times) {
		for (int i = 0; i < s.length(); i++) {
			int index = getInt(s.charAt(i));
			if (t.branchs[index] == null) {
				t.branchs[index] = new Trie();
			}
			t = t.branchs[index];
		}
		t.times += times;
	}

	private List<Node> lookup(Trie t, String s) {
		List<Node> res = new ArrayList<Node>();

		for (int i = 0; i < s.length(); i++) {
			int index = getInt(s.charAt(i));
			if (t.branchs[index] == null) {
				return new ArrayList<Node>();
			}
			t = t.branchs[index];
		}

		traverse(s, t, res);

		return res;
	}

	private void traverse(String s, Trie t, List<Node> list) {

		if (t.times > 0) {
			list.add(new Node(s, t.times));
		}
		for (char i = 'a'; i <= 'z'; i++) {
			if (t.branchs[i - 'a'] != null) {
				traverse(s + i, t.branchs[i - 'a'], list);
			}
		}

		if (t.branchs[26] != null) {
			traverse(s + ' ', t.branchs[26], list);
		}
	}

	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new Trie();
		for (int i = 0; i < sentences.length; i++) {
			insert(root, sentences[i], times[i]);
		}
	}

	public List<String> input(char c) {
		List<String> res = new ArrayList<String>();
		if (c == '#') {
			insert(root, cur_sen, 1);
			cur_sen = "";
		} else {
			cur_sen += c;
			List<Node> list = lookup(root, cur_sen);
			Collections.sort(
					list,
					(a, b) -> a.times == b.times ? a.sentence
							.compareTo(b.sentence) : b.times - a.times);
			for (int i = 0; i < Math.min(3, list.size()); i++) {
				res.add(list.get(i).sentence);
			}
		}
		return res;
	}
}