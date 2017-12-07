package problem_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = new MainTest().createTree(root);
		List<Integer> list = new MainTest().preorderTraversal(root);
		System.out.println(list);
	}
	
	//非递归
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		List<Integer> list = new ArrayList<Integer>();
		while(tmp != null || !stack.isEmpty()) {
			while(tmp != null) {
				list.add(tmp.val);
				stack.push(tmp);
				tmp = tmp.left;
			}
			if(!stack.isEmpty()) {
				tmp = stack.peek();
				stack.pop();
				tmp = tmp.right;
			}
		}
		return list;
	}
	
	//递归
/*	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		list = dfs(root, list);
		return list;
	}
	public static List<Integer> dfs(TreeNode root, List<Integer> list) {
		if(root == null) {
			return list;
		}
		else {
			list.add(root.val);
			list = dfs(root.left, list);
			list = dfs(root.right, list);
			return list;
		}
	}*/

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

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
