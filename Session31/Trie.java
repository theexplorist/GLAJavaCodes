package Session31;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public class Node {
		char data;
		Map<Character, Node> children;
		boolean isMarked;

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
		}

		curr.isMarked = true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
