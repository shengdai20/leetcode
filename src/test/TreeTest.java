package test;

import java.util.Stack;

public class TreeTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = new TreeTest().createTree(root);
//		new TreeTest().preOrder(root);
		root = new TreeTest().reverse(root);
		new TreeTest().preOrder(root);
	}
	
	public TreeNode reverse(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		//压栈然后倒序输出
		while(tmp != null) {
			stack.push(tmp);
			tmp = tmp.right;
		}
		root = null;
		TreeNode next = null;
		//有点类似单链表的实现
		while(!stack.isEmpty()) {
			if(root == null) {
				root = stack.pop();
				tmp = root;
			}
			else {
				next = stack.pop();
				root.right = next;
				root = next;
			}
		}
		root.right = null;
		return tmp;
	}
/*	public TreeNode reverse(TreeNode root) {
		if((root == null) || (root.left == null && root.right == null)) {
			return root;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		if(root.left != null) {
			reverse(root.left);
		}
		if(root.right != null) {
			reverse(root.right);
		}
		return root;
	}*/
	
	public void preOrder(TreeNode root) {
		if(root != null) {
			System.out.println(root.val);
			if(root.left != null) {
				System.out.println("left:" + root.val);
			}
			preOrder(root.left);
			if(root.right != null) {
				System.out.println("right:" + root.val);
			}
			preOrder(root.right);
		}
	}
	
	public TreeNode createTree(TreeNode root) {
		root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = null;
		root.right.right = new TreeNode(3);
		root.right.right.left = null;
		root.right.right.right = null;
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}
