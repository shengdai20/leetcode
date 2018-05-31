package problem_117;

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
		root.right.left = null;
		root.right.right = new TreeLinkNode(7);
		root.right.right.next = null;
		root.left.left.left = null;
		root.left.left.right = null;
		root.left.right.left = null;
		root.left.right.right = null;
		root.right.right.left = null;
		root.right.right.right = null;
		new Main().connect(root);
	}
	
	public void connect(TreeLinkNode root) {
		TreeLinkNode nextLevel = new TreeLinkNode(0), cur = nextLevel;
		while(root != null) {
			if(root.left != null) {
				//这里其实就是改变了pre.next，因为cur=pre，改变cur就是改变pre
				cur.next = root.left;
				cur = cur.next;
			}
			if(root.right != null) {
				cur.next = root.right;
				cur = cur.next;
			}
			root = root.next;
			//如果到了当前层结尾
			if(root == null) {
				//重置cur
				cur = nextLevel;
				//重置root为下一层的第一个结点
				root = nextLevel.next;
				//重置nextLevel
				nextLevel.next = null;
			}
		}
	}
	
/*	public void connect(TreeLinkNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			//当前层一共有多少结点数
			int len = q.size();
			//遍历当前层的所有结点
			for(int i = 0; i < len; i++) {
				TreeLinkNode tmp = q.poll();
				//注意只计算到当前层倒数第二个结点即可。因为如果计算到最后一个的话，q中有值，会导致next出错。
				if(i < len - 1) {
					tmp.next = q.peek();
				}
				if(tmp.left != null) {
					q.offer(tmp.left);
				}
				if(tmp.right != null) {
					q.offer(tmp.right);
				}
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
