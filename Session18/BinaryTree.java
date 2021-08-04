package Session18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class BinaryTree {

	private Scanner sc = new Scanner(System.in);

	private class Node {

		int val;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {

		this.root = construct(null, true);
	}

	// parent -> null(root)
	// ilc -> true(User wants to give input for left child)
	// ilc -> false(User wants to give input for right child)
	private Node construct(Node parent, boolean isLeftChild) {
		// TODO Auto-generated method stub

		if (parent == null) {
			System.out.println("Enter the data for root node!");
		} else {
			if (isLeftChild) {
				System.out.println("Enter the data for left child of " + parent.val);
			} else {
				System.out.println("Enter the data for right child of " + parent.val);
			}
		}

		int val = sc.nextInt();

		Node node = new Node();
		node.val = val;

		System.out.println("Kya " + node.val + "ka left child hai?");

		boolean kyaLeftHai = sc.nextBoolean(); // true

		if (kyaLeftHai) {
			node.left = construct(node, true);
		}

		System.out.println("Kya " + node.val + "ka right child hai?");

		boolean kyaRightHai = sc.nextBoolean(); // true

		if (kyaRightHai) {
			node.right = construct(node, false);
		}

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

	public int maxDepth() {
		return this.maxDepth(this.root);
	}

	private int maxDepth(Node root) {

		if (root == null) {
			return 0;
		}
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);

		int meriHeight = Math.max(leftHeight, rightHeight) + 1;

		return meriHeight;
	}

	public void preOrder() {
		// TODO Auto-generated method stub

		this.preOrder(this.root);
	}

	private void preOrder(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}

		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder() {
		// TODO Auto-generated method stub

		this.inOrder(this.root);
	}

	private void inOrder(Node root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);

	}

	class Pair {
		Node node;
		int vertLvl;

		public Pair(Node node, int vertLvl) {
			this.node = node;
			this.vertLvl = vertLvl;
		}
	}

	public void vertOrder() {

		this.vertOrder(root);
	}

	private void vertOrder(Node root) {

		Queue<Pair> bfs = new LinkedList<>();
		bfs.add(new Pair(root, 0));

		Map<Integer, List<Integer>> map = new TreeMap<>();
		while (!bfs.isEmpty()) {
			Pair front = bfs.poll();
			Node curr = front.node;
			int vertLvl = front.vertLvl;
			
			//vertLvl -> list of nodes at that lvl
			
			List<Integer> lvlList = map.getOrDefault(vertLvl, new ArrayList<>());
			lvlList.add(curr.val);
			map.put(vertLvl, lvlList);
			
			if(curr.left != null) {
				bfs.add(new Pair(curr.left, vertLvl - 1));
			}
			
			if(curr.right != null) {
				bfs.add(new Pair(curr.right, vertLvl + 1));
			}
		}
		
		System.out.println(map);

	}

}
