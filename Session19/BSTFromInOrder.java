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

	public int max() {
		return this.max(root);
	}

	private int max(Node root) {

		if (root.right == null) {
			return root.val;
		}
		return max(root.right);
	}

	public boolean find(int value) {
		return this.find(root, value);
	}

	private boolean find(Node root, int value) {
		// TODO Auto-generated method stub

		if (root == null) {
			return false;
		}
		if (value < root.val) {
			return this.find(root.left, value);
		} else if (value > root.val) {
			return this.find(root.right, value);
		} else {
			return true;
		}
	}

	int sum = 0;

	public void replaceWithLarger() {
		replaceWithLarger(this.root);
	}

	private void replaceWithLarger(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}
		// right
		replaceWithLarger(root.right);
		// self
		int temp = root.val;
		root.val = sum;
		sum = sum + temp;
		// left
		replaceWithLarger(root.left);

	}

	public void printInRange(int low, int high) {
		// TODO Auto-generated method stub
		printInRange(this.root, low, high);
	}

	private void printInRange(Node root, int low, int high) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}
		if (root.val < low) {
			printInRange(root.right, low, high);
		} else if (root.val > high) {
			printInRange(root.left, low, high);
		} else { // in or on range
			
			printInRange(root.left, low, high);
			System.out.println(root.val);
			printInRange(root.right, low, high);
		}
	}

}
