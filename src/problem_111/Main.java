package problem_111;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	static class MergeTree {
		TreeNode root;
		int depth;
		MergeTree(TreeNode r, int d) {
			root = r;
			depth = d;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int res = new Main().minDepth(root);
		System.out.println(res);
	}

	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return dfs(root, Integer.MAX_VALUE, 1);
	}
	private static int dfs(TreeNode root, int res, int cnt) {
		if(root.left == null && root.right == null) {
			return Math.min(res, cnt);
		}
		if(root.left != null) {
			res = dfs(root.left, res, cnt + 1);
		}
		if(root.right != null) {
			res = dfs(root.right, res, cnt + 1);
		}
		return res;
	}
	
/*	public int minDepth(TreeNode root) {
		int res = Integer.MAX_VALUE;
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> de = new LinkedList<Integer>();
		q.offer(root);
		de.offer(1);
		while(!q.isEmpty()) {
			TreeNode tmp = q.poll();
			int t = de.poll();
			if(tmp.left != null) {
				q.offer(tmp.left);
				de.offer(t + 1);
			}
			if(tmp.right != null) {
				q.offer(tmp.right);
				de.offer(t + 1);
			}
			if(tmp.left == null && tmp.right == null) {
				res = Math.min(res, t);
			}
		}
		return res;
	}*/
	
/*	public int minDepth(TreeNode root) {
		int res = Integer.MAX_VALUE;
		if(root == null) {
			return 0;
		}
		Queue<MergeTree> q = new LinkedList<MergeTree>();
		MergeTree mT = new MergeTree(root, 1);
		q.offer(mT);
		while(!q.isEmpty()) {
			MergeTree tmpT = q.poll();
			TreeNode tmpN = tmpT.root;
			if(tmpN.left != null) {
				mT = new MergeTree(tmpN.left, tmpT.depth + 1);
				q.offer(mT);
			}
			if(tmpN.right != null) {
				mT = new MergeTree(tmpN.right, tmpT.depth + 1);
				q.offer(mT);
			}
			if(tmpN.left == null && tmpN.right == null) {
				res = Math.min(res, tmpT.depth);
			}
		}
		return res;
	}*/
}
