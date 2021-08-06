package Session19;

import Session19.InsertInBST.TreeNode;

public class DeleteFromBST {

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

	public int min(TreeNode root) {
		if(root.left == null) {
			return root.val;
		}
		return min(root.left);
	}
	public TreeNode deleteNode(TreeNode root, int key) {

		if(key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if(key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {//key == root.val
			
			//leaf node
			if(root.left == null && root.right == null) {
				return null;
			} else if(root.right == null) {
				return root.left;
			} else if(root.left == null) {
				return root.right;
			} else {
				//immmediate big successor
				int minValueRight = min(root.right);
				
				root.val = minValueRight;
				
				root.right = deleteNode(root.right, minValueRight);
			}
		}
		
		return root;
	}
}
