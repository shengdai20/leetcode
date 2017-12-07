package problem_100;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class MainTest {

	public static void main(String[] args) {
		TreeNode p = null;
		p = createTreeP(p);
		TreeNode q = null;
		q = createTreeQ(q);
	//	System.out.println("p:" + p + ", q:" + q);
		boolean res = isSameTree1(p, q);
		System.out.println("res:" + res);
	}

	private static boolean isSameTree1(TreeNode p, TreeNode q) {
		Queue<TreeNode> queueP = new LinkedList<TreeNode>();
		Queue<TreeNode> queueQ = new LinkedList<TreeNode>();
		queueP.offer(p);
		queueQ.offer(q);
		boolean flag = true;
		while(!queueP.isEmpty() && !queueQ.isEmpty()) {
			TreeNode nodeP = queueP.poll();
			TreeNode nodeQ = queueQ.poll();
			if((nodeP == null && nodeQ != null) || (nodeP != null && nodeQ == null)) {
				return false;
			}
			else if(nodeP != null && nodeQ != null) {
				if(nodeP.val != nodeQ.val) {
					return false;
				}
				else {
					queueP.offer(nodeP.left);
					queueP.offer(nodeP.right);
					queueQ.offer(nodeQ.left);
					queueQ.offer(nodeQ.right);
				}
			}
		}
		if(!queueP.isEmpty() || !queueQ.isEmpty()) {
			return false;
		}
		return flag;
	}
	
	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		}
		if(p == null || q == null) {
			return false;
		}
		else {
			if(p.val != q.val) {
				return false;
			}
			else {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
		}
	}

	private static TreeNode createTreeP(TreeNode p) {
		p = new TreeNode(1);
//		p.left = new TreeNode(2);
//		p.right = new TreeNode(3);
	//	p = null;
		return p;
	}
	
	private static TreeNode createTreeQ(TreeNode q) {
		q = new TreeNode(1);
//		q.left = new TreeNode(2);
//		q.right = new TreeNode(3);
//		q.left.left = new TreeNode(3);
//		q = null;
		return q;
	}
}
