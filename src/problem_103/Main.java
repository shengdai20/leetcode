package problem_103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.left = null;
		root.right.left.right = null;
		root.right.right.left = null;
		root.right.right.right = null;
		List<List<Integer>> res = new Main().zigzagLevelOrder(root);
		System.out.println(res);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int level = 0;
		while(!q.isEmpty()) {
			level++;
			int cnt = q.size();
			List<Integer> listLevel = new ArrayList<Integer>();
			for(int i = 0; i < cnt; i++) {
				TreeNode tmp = q.poll();
				listLevel.add(tmp.val);
				if(tmp.left != null) {
					q.offer(tmp.left);
				}
				if(tmp.right != null) {
					q.offer(tmp.right);
				}
			}
			//对list进行翻转
			if(level % 2 == 0)
				Collections.reverse(listLevel);
			res.add(new ArrayList<Integer>(listLevel));
		}
		return res;
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
