package problem_116;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.next = null;
		root.left = new TreeLinkNode(2);
		root.left.next = null;
		root.right = new TreeLinkNode(3);
		root.right.next = null;
		root.left.left = new TreeLinkNode(4);
		root.left.left.next = null;
		root.left.right = new TreeLinkNode(5);
		root.left.right.next = null;
		root.right.left = new TreeLinkNode(6);
		root.right.left.next = null;
		root.right.right = new TreeLinkNode(7);
		root.right.right.next = null;
		root.left.left.left = null;
		root.left.left.right = null;
		root.left.right.left = null;
		root.left.right.right = null;
		root.right.left.left = null;
		root.right.left.right = null;
		root.right.right.left = null;
		root.right.right.right = null;
		new Main().connect(root);
	}

	public void connect(TreeLinkNode root) {
		if(root == null) {
			return;
		}
		TreeLinkNode pre = root, cur = null;
		//外层循环是遍历到二叉树的第几层
		while(pre.left != null) {
			cur = pre;
			//里层循环是针对每一层，将其下面一层形成单链表
			while(cur != null) {
				//左孩子的next一定是右孩子
				cur.left.next = cur.right;
				//右孩子的next要么是null要么是当前结点右兄弟的左孩子
				if(cur.next != null) {
					cur.right.next = cur.next.left;
				}
				//遍历当前结点的右兄弟
				cur = cur.next;
			}
			pre = pre.left;
		}
	}
	
/*	public void connect(TreeLinkNode root) {
		if(root == null) {
			return;
		}
		//由于是完全二叉树，所以如果存在左结点，一定存在右结点
		if(root.left != null) {
			root.left.next = root.right;
		}
		if(root.right != null) {
			//如果当前结点有右兄弟，则其右孩子的next指向其右兄弟的左孩子
			if(root.next != null) {
				root.right.next = root.next.left;
			}
			//如果没有右兄弟，则说明是当前层最后一个结点
			else {
				root.right.next = null;
			}
		}
		connect(root.left);
		connect(root.right);
	}*/
	
/*	public void connect(TreeLinkNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.offer(root);
		//标记当前层最后一个结点
		TreeLinkNode end = root;
		while(!q.isEmpty()) {
			TreeLinkNode tmp = q.poll();
			if(tmp.left != null) {
				q.offer(tmp.left);
			}
			if(tmp.right != null) {
				q.offer(tmp.right);
			}
			//如果已经到了当前层最后一个结点
			if(tmp == end) {
				tmp.next = null;
				end = tmp.right;
			}
			else {
				tmp.next = q.peek();
			}
		}
	}*/
}
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		val = x;
	}
}
