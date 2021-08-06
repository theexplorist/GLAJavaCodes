package Session19;

public class ValidateBST {

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

	public boolean isValidBST(TreeNode root) {
		return sol(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean sol(TreeNode root, long min, long max) {

		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		boolean left = sol(root.left, min, root.val);
		boolean right = sol(root.right, root.val, max);

		return left && right;
	}
}
