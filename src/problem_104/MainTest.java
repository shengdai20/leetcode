package problem_104;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class MainTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = createTree(root);
		int depth = maxDepth1(root);
		System.out.println("depth:" + depth);
	}

	private static int maxDepth1(TreeNode root) {
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 0;
		int width = 1;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			width--;
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
			if(width == 0) {
				depth++;
				width = queue.size();
			}
		}
		return depth;
	}
	
	private static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
	}

	private static TreeNode createTree(TreeNode root) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		return root;
	}
	
}
