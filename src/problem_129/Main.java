package problem_129;

public class Main {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
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
		root.right.right.left = null;
		root.right.right.right.left = null;
		root.right.right.right.right = null;
		int res = new Main().sumNumbers(root);
		System.out.println(res);
	}
	
	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int res = 0;
		res = dfs(root, 0, res);
		return res;
	}
	private static int dfs(TreeNode root, int cnt, int res) {
		//计算最后叶节点的数值，由于前面有判断进来的节点是否为null，所以这里root一定是非空节点
		if(root.left == null && root.right == null) {
			res += cnt * 10 + root.val;
			return res;
		}
		//计算根节点的数值
		cnt = cnt * 10 + root.val;
		//如果有左孩子，遍历左孩子
		if(root.left != null) {
			res = dfs(root.left, cnt, res);
		}
		//如果有右孩子，遍历右孩子
		if(root.right != null) {
			res = dfs(root.right, cnt, res);
		}
		return res;
	}
}
