package problem_107;

import java.util.LinkedList;
import java.util.List;
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
		TreeNode root = null;
		root = createTree(root);
		List<List<Integer>> listOrder = null;
		listOrder = levelOrderBottom(root);
		for(int i = 0; i < listOrder.size(); i++) {
			System.out.println(listOrder.get(i));
		}
	}

	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		levelDFS(res, root, 0);
		return res;
	}
	//后序遍历
	private static void levelDFS(List<List<Integer>> list, TreeNode root, int level) {
		if(root == null) {
			return;
		}
		//如果层数大于当前list的大小，则扩充list大小
		if(level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelDFS(list, root.left, level + 1);
		levelDFS(list, root.right, level + 1);
		//由于是倒序输出，所以这里要-level-1，以将倒数几层安排到正数几层进行输出
		list.get(list.size() - level - 1).add(root.val);
	}
	
/*	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> listOrder = new LinkedList<List<Integer>>();
		if(root == null) {
			return listOrder;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			int len = q.size();
			List<Integer> listIn = new LinkedList<Integer>();
			//一层一起遍历
			for(int i = 0; i < len; i++) {
				TreeNode tmp = q.poll();
				if(tmp.left != null) {
					q.offer(tmp.left);
				}
				if(tmp.right != null) {
					q.offer(tmp.right);
				}
				listIn.add(tmp.val);
			}
			//由于是链表List，所以下面的方法相当于头插，在第0号位置插入元素
			listOrder.add(0, listIn);
		}
		return listOrder;
	}*/
	
/*	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null) {
			return new LinkedList<List<Integer>>();
		}
		List<List<Integer>> listOrder = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		//记录每层的结点个数
		int cnt = 1;
		List<Integer> listLevel = new LinkedList<Integer>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			listLevel.add(node.val);
			cnt--;
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
			if(cnt == 0) {
				listOrder.add(listLevel);
				cnt = queue.size();
				listLevel = new LinkedList<Integer>();
			}
		}
		//将list翻转返回
		List<List<Integer>> listRes = new LinkedList<List<Integer>>();
		int length = listOrder.size();
		for(int i = length - 1; i >= 0; i--) {
			listRes.add(listOrder.get(i));
		}
		return listRes;
	}*/

	private static TreeNode createTree(TreeNode root) {
		root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		return root;
	}
	
}
