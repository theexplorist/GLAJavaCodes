package Session19;

public class BSTFromInOrder {

	private class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root;

	public BSTFromInOrder(int[] in) {
		// TODO Auto-generated constructor stub
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int l, int r) {
		// TODO Auto-generated method stub

		if (l > r) {
			return null;
		}

		int mid = (l + r) / 2;

		Node node = new Node();
		node.val = in[mid];

		node.left = construct(in, l, mid - 1);
		node.right = construct(in, mid + 1, r);

		return node;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}

		String str = "";

		if (root.left != null) {
			str += root.left.val;
		} else {
			str += "_";
		}

		str += " -> " + root.val + " <- ";

		if (root.right != null) {
			str += root.right.val;
		} else {
			str += "_";
		}

		System.out.println(str);

		display(root.left);
		display(root.right);
	}
}
