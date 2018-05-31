package problem_124;

public class Main {

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = null;
		root.right.right = null;
		root.left.left.left = null;
		root.left.left.right = null;
		root.left.right.left = null;
		root.left.right.right = null;
		int res = new Main().maxPathSum(root);
		System.out.println(res);
	}
	//设为全局，方便计算，因为最大值有可能是中间路径，所以如果只是作为参数返回的话，不好承接
	int res = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		dfs(root);
		return res;
	}
	private int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}
		//计算左子树最大路径和
		int left = Math.max(dfs(root.left), 0);
		//计算右子树最大路径和
		int right = Math.max(dfs(root.right), 0);
		//求max
		res = Math.max(res, left + right + root.val);
		//取左子树和右子树的较大值，再加上当前根值返回给上一级
		return Math.max(left, right) + root.val;
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
