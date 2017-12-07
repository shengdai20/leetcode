package problem_112;

import java.util.Stack;

public class PostTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = new MainTest().createTree(root);
		int sum = 22;
		boolean res = new PostTest().hasPathSum(root, sum);
		System.out.println(res);
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null) {
			return false;
		}
		stack.push(root);
		TreeNode pre = null, cur = root.left;
		int cnt = root.val;
		while(!stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				cnt += cur.val;
				cur = cur.left;
			}
			cur = stack.peek();
			if(cur.left == null && cur.right == null && cnt == sum) {
				return true;
			}
			if(cur.right != null && pre != cur.right) {
				cur = cur.right;
			}
			else {
				cnt -= cur.val;
				stack.pop();
				pre = cur;
				cur = null;
			}
		}
		return false;
	}
	
/*	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> stackFlag = new Stack<Integer>();
		stack.push(root);
		stackFlag.push(0);
		TreeNode tmp = root.left;
		int cnt = root.val;
		while(!stack.isEmpty()) {
			while(tmp != null) {
				cnt += tmp.val;
				stack.push(tmp);
				stackFlag.push(0);
				tmp = tmp.left;
			}
			if(!stack.isEmpty()) {
				if(stackFlag.peek() == 0) {
					tmp = stack.peek().right;
					stackFlag.pop();
					stackFlag.push(1);
				}
				else {
					if(cnt == sum && stack.peek().left == null && stack.peek().right == null) {
						return true;
					}
					cnt -= stack.pop().val;
					stackFlag.pop();
				}
			}
		}
		return false;
	}*/
}
