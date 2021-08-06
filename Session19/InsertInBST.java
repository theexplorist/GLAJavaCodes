package Session19;

public class InsertInBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// TODO Auto-generated method stub

	public TreeNode insertIntoBST(TreeNode root, int val) {

		if (root == null) {
			TreeNode node = new TreeNode(val);
			root = node;
		} else {
			insert(root, val);
		}

		return root;
	}

	public void insert(TreeNode root, int val) {
		if (root.val > val) {
			// left
			if (root.left != null) {
				insert(root.left, val);
			} else {
				TreeNode node = new TreeNode(val);
				root.left = node;
			}

		} else if (root.val < val) {
			// right
			if (root.right != null) {
				insert(root.right, val);
			} else {
				TreeNode node = new TreeNode(val);
				root.right = node;
			}
		}
	}

}
