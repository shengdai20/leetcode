package problem_113;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = new MainTest().createTree(root);
		int sum = 22;
		List<List<Integer>> ans = new MainTest().pathSum(root, sum);
		System.out.println(ans);
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode pre = null, cur = root.left;
		List<Integer> listIn = new ArrayList<Integer>();
		listIn.add(root.val);
		int cnt = root.val;
		while(!stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				listIn.add(cur.val);
				cnt += cur.val;
				cur = cur.left;
			}//System.out.println(listIn);
			cur = stack.peek();
			if(cur.left == null && cur.right == null && cnt == sum) {
				//每次加入的时候新new一个对象，这个很重要
				list.add(new ArrayList<Integer>(listIn));
			}
			if(cur.right != null && pre != cur.right) {
				cur = cur.right;
			}
			else {
				cnt -= cur.val;
				listIn.remove(listIn.size() - 1);
				stack.pop();
				pre = cur;
				cur = null;
			}
		}
		return list;
	}
	
	public TreeNode createTree(TreeNode root) {
/*		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = null;
		root.left.left = null;
		root.left.right = null;
		return root;*/
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.right = null;
		root.right.left = new TreeNode(13);
		root.right.left.left = null;
		root.right.left.right = null;
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.left.left = null;
		root.left.left.left.right = null;
		root.left.left.right = new TreeNode(2);
		root.left.left.right.left = null;
		root.left.left.right.right = null;
		root.right.right.right = new TreeNode(1);
		root.right.right.left = new TreeNode(5);
		root.right.right.left.left = null;
		root.right.right.left.right = null;
		root.right.right.right.left = null;
		root.right.right.right.right = null;
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