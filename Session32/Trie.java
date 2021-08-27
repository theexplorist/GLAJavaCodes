package Session32;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public class Node {
		char data;
		Map<Character, Node> children;
		boolean isMarked;
		int count = 0;

		public Node(char data) {
			this.data = data;// c
			this.children = new HashMap<>();
			this.isMarked = false;
		}
	}

	Node root;

	public Trie() {
		this.root = new Node('*');
	}

	private void insert(String word) {// RAJ
		// TODO Auto-generated method stub

		Node curr = root;
		for (char c : word.toCharArray()) {// 'R' 'A' 'J'
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);// curr ko child ke addreess pr point krado
			} else {
				Node n = new Node(c);
				curr.children.put(c, n);
				curr = n;
			}

			curr.count++;
		}

		curr.isMarked = true;
	}

	private boolean search(String word) {
		// TODO Auto-generated method stub

		// 'R', 'A', 'J'
		Node curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return false;
			}
		}

		return curr.isMarked;
	}

	private boolean startsWith(String prefix) {
		// TODO Auto-generated method stub
		Node curr = root;
		for (char c : prefix.toCharArray()) {
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return false;
			}
		}

		return true;
	}

	private int countPrefix(String prefix) {
		// TODO Auto-generated method stub
		Node curr = root;

		for (char c : prefix.toCharArray()) {
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return 0;
			}
		}

		return curr.count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie trie = new Trie();
//		trie.insert("RAJ");
//		trie.insert("RAM");
//		
//		System.out.println(trie.search("RA"));
//		trie.insert("RA");
//		System.out.println(trie.search("RA"));
//		trie.insert("apple");
//		System.out.println(trie.search("apple"));
//		System.out.println(trie.search("app"));
//		System.out.println(trie.startsWith("ape"));
		trie.insert("hack");
		trie.insert("hackerrank");
		System.out.println(trie.startsWith("hac"));
		System.out.println(trie.countPrefix("rank"));
	}

}
