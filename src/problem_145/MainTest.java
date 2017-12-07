package problem_145;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = new MainTest().createTree(root);
		List<Integer> ans = new MainTest().postorderTraversal(root);
		System.out.println(ans);
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode pre = null, cur = root.left;
		while(!stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.peek();//判断栈顶结点是否弹出
			if(cur.right != null && pre != cur.right) {
				//如果不是从有孩子返回，即还未访问右孩子，则访问
				cur = cur.right;
			}
			else {
				//如果没有右孩子，则直接弹出根节点，并将当前结点赋空
				list.add(cur.val);
				stack.pop();
				pre = cur;
				cur = null;
			}
		}
		return list;
	}
	
/*	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode pre = null, cur = null;
		while(!stack.isEmpty()) {
			cur = stack.peek();//判断当前结点情况，所以用peek不用pop
			if((cur.left == null && cur.right == null) || 
				(pre != null && (pre == cur.left || pre == cur.right))) {
				//如果当前结点没有左右孩子则直接弹出当前结点
				//如果当前结点的左右孩子都已经访问完则弹出当前结点
				list.add(cur.val);
				pre = cur;
				stack.pop();
			}
			else {
				//注意这里一定要先压right再压left，因为栈的先进后出的原则，到时候会先弹出left再弹出right，这样的顺序才正确。
				if(cur.right != null) {
					stack.push(cur.right);
				}
				if(cur.left != null) {
					stack.push(cur.left);
				}
			}
		}
		return list;
	}*/
	
	//法三
/*	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stackNode = new Stack<TreeNode>();
		//0表示右结点未访问，1表示右结点已访问
		Stack<Integer> stackFlag = new Stack<Integer>();
		stackNode.push(root);
		stackFlag.push(0);
		TreeNode tmp = root.left;//已压栈，则访问其左结点
		while(!stackNode.isEmpty()) {
			while(tmp != null) {
				stackNode.push(tmp);
				stackFlag.push(0);
				tmp = tmp.left;
			}
			if(stackFlag.peek() == 0) {
				//右结点未访问，则访问右结点
				tmp = stackNode.peek().right;
				stackFlag.pop();
				stackFlag.push(1);//将访问右结点状态置1
			}
			else {
				//右结点已访问，则将根结点加入list队列，并将根节点弹出
				list.add(stackNode.pop().val);
				stackFlag.pop();//弹出根节点状态值
			}
		}
		return list;
	}*/
	
	//法二
/*	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		list = dfs(root, list);
		return list;
	}
	public static List<Integer> dfs(TreeNode root, List<Integer> list) {
		if(root == null) {
			return list;
		}
		else {
			list = dfs(root.left, list);
			list = dfs(root.right, list);
			list.add(root.val);
			return list;
		}
	}*/
	
	//法一
/*	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode tmp = null;
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			list.addFirst(tmp.val);
			if(tmp.left != null) {
				stack.push(tmp.left);
			}
			if(tmp.right != null) {
				stack.push(tmp.right);
			}
		}
		return list;
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
