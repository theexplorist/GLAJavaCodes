package Session18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

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

	public List<Integer> rightSideView(TreeNode root) {

		Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        List<Integer> rightView = new ArrayList<>();
        while(!bfs.isEmpty()) {
            
            int n = bfs.size();
            for(int i = 0; i < n; i++) {
                
                TreeNode front = bfs.poll();
               
                if(i == n - 1) {
                	rightView.add(front.val);
                }
                if(front.left != null) {
                bfs.add(front.left);
                }
            
                if(front.right != null) {
                bfs.add(front.right);
                }
            }
            
        }
        
        return rightView;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
