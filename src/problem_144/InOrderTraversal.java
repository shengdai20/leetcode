package problem_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
	
	public static void main(String[] args) {
		TreeNode root = null;
		root = new InOrderTraversal().createTree(root);
		List<Integer> list = new InOrderTraversal().inorderTraversal(root);
		System.out.println(list);
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		while(tmp != null || !stack.isEmpty()) {
			while(tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
			//与先序不同的是，在弹出时放入结果list
			if(!stack.isEmpty()) {
				tmp = stack.pop();
				list.add(tmp.val);
				tmp = tmp.right;
			}
		}
		return list;
	}
	
	public TreeNode createTree(TreeNode root) {
		root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = null;
		root.right.left.left = null;
		root.right.left.right = null;
		return root;
	}

}

