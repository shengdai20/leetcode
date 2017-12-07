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
		if(root == null) {
			return new LinkedList<List<Integer>>();
		}
		List<List<Integer>> listOrder = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
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
		List<List<Integer>> listRes = new LinkedList<List<Integer>>();
		int length = listOrder.size();
		for(int i = length - 1; i >= 0; i--) {
			listRes.add(listOrder.get(i));
		}
		return listRes;
	}

	private static TreeNode createTree(TreeNode root) {
		root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		return root;
	}
	
}
