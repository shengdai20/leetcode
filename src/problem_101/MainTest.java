package problem_101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		TreeNode root = null;
//		root = createTreePreOrder(root);
//		root = createTreeRankTree(root, 2);
//		root = createTreeRankTree(root, 1);
//		root = createTreeRankTree(root, 3);
		root = createTree(root);
		inOrder(root);
		boolean result = isSymmetric(root);
		System.out.println("result:" + result);
	}

	public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cnt = 1;
        List<TreeNode> listNode = new ArrayList<TreeNode>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            cnt--;
            listNode.add(node);
            if(node != null) {
            	queue.offer(node.left);
            	queue.offer(node.right);
            }
            if(cnt == 0) {
                cnt = queue.size();
                int length = listNode.size();
                for(int i = 0; i < length / 2; i++) {
                    if((listNode.get(i) == null && listNode.get(length - 1 - i) != null) ||
                        (listNode.get(i) != null && listNode.get(length - 1 - i) == null)) {
                        flag = false;
                        break;
                    }
                    else if(listNode.get(i) != null && listNode.get(length - 1 - i) != null) {
                        if(listNode.get(i).val != listNode.get(length - 1 - i).val) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag == false) {
                    return flag;
                }
                listNode.clear();
            }
        }
        return flag;
    }
	
	private static TreeNode createTree(TreeNode root) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = null;
		root.left.right = new TreeNode(3);
		root.right.left = null;
		root.right.right = new TreeNode(3);
		return root;
	}
	private static void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.println("num:" + root.val);
			inOrder(root.right);
		}
	}

	//先序构建二叉树，以0为输入结束点，只是这里要将叶节点的0全部输入才可结束
	private static TreeNode createTreePreOrder(TreeNode root) {
		int num = 0;
		try {
			num = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		if(num == 0) {
			root = null;
			return root;
		}
		root = new TreeNode(num);
		root.left = createTreePreOrder(root.left);
		root.right = createTreePreOrder(root.right);
		return root;
	}
	
	//构建排序二叉树
	private static TreeNode createTreeRankTree(TreeNode root, int num) {
		if(root == null) {
			root = new TreeNode(num);
			root.left = null;
			root.right = null;
			return root;
		}
		else if(num < root.val) {
			root.left = createTreeRankTree(root.left, num);
			return root;
		}
		else {
			root.right = createTreeRankTree(root.right, num);
			return root;
		}
	}
}
