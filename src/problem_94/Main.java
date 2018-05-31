package problem_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left = null;
		root.right.left = new TreeNode(3);
		root.right.right = null;
		List<Integer> res = new Main().inorderTraversal(root);
		System.out.println(res);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		TreeNode tmp = root;
		while(!s.isEmpty() || tmp != null) {
			//压入左孩子结点
			while(tmp != null) {
				s.push(tmp);
				tmp = tmp.left;
			}
			//如果栈非空，弹出顶结点，遍历右子树
			if(!s.isEmpty()) {
				tmp = s.pop();
				res.add(tmp.val);
				tmp = tmp.right;
			}
		}
		return res;
	}
	
/*	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(res, root);
		return res;
	}
	private void dfs(List<Integer> res, TreeNode root) {
		if(root != null) {
			dfs(res, root.left);
			res.add(root.val);
			dfs(res, root.right);
		}
	}*/
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}