package problem_110;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(4);
		root.left.left.left.left = null;
		root.left.left.left.right = null;
		root.left.left.right.left = null;
		root.left.left.right.right = null;
		root.left.right.left = null;
		root.left.right.right = null;
		root.right.left = null;
		root.right.right = null;
		boolean res = new Main().isBalanced(root);
		System.out.println(res);
	}
	
	public boolean isBalanced(TreeNode root) {
		return (dfs(root) == -1) ? false : true;
	}
	private int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}
		//记录左子树高度
		int l = dfs(root.left);
		//如果左子树是非平衡树，则直接返回-1，不用进行下面的操作
		if(l == -1) {
			return -1;
		}
		//记录右子树高度
		int r = dfs(root.right);
		if(r == -1) {
			return -1;
		}
		//比较左右子树的高度，如果是非平衡的，则返回-1
		if(Math.abs(l - r) > 1) {
			return -1;
		}
		//如果目前来说是平衡的，则返回当前平衡树的高度
		else {
			return 1 + Math.max(l, r);
		}
	}
	
/*	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		//计算左子树高度
		int l = dfs(root.left);
		//计算右子树高度
		int r = dfs(root.right);
		//比较左子树和右子树高度
		if(Math.abs(l - r) > 1) {
			return false;
		}
		//如果左右子树有非平衡二叉树，则整体就是平衡二叉树，否则就不是
		return isBalanced(root.left) && isBalanced(root.right);
	}
	//计算二叉树的高度
	private int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int l = dfs(root.left);
		int r = dfs(root.right);
		return (l > r) ? (l + 1) : (r + 1);
	}*/

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}