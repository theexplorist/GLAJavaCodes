package Session19;

import java.util.HashMap;
import java.util.Map;

public class PreInBuild {

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

	Map<Integer, Integer> inOrdMap;
	int iter;
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		int n = preorder.length;
		iter = 0;
		inOrdMap = new HashMap<>();
		//element - index
		for(int i = 0; i < inorder.length; i++) {
			inOrdMap.put(inorder[i], i);
		}
		
		return build(preorder, 0, n - 1);
	}
	
	private TreeNode build(int[] preorder, int l, int r) {
		// TODO Auto-generated method stub

		if(l > r) {
			return null;
		}
		
		int value = preorder[iter++]; //3
		TreeNode root = new TreeNode(value);
		
		int index = inOrdMap.get(value); //1
		
		//left subtree banao
		root.left = build(preorder, l, index - 1);
		
		//right subtree banao
		root.right = build(preorder, index + 1, r);
		
		return root;
	}

}
