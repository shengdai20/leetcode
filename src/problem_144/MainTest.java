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
			//将所有左孩子压栈，直到没有左孩子，并且由于是先序遍历，所以在压左孩子的时候就放入结果list中
			while(tmp != null) {
				list.add(tmp.val);
				stack.push(tmp);
				tmp = tmp.left;
			}
			//如果左孩子压完了，就访问右孩子
			if(!stack.isEmpty()) {
				tmp = stack.pop();
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
