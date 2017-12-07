package problem_112;

public class MainTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = new MainTest().createTree(root);
		int sum = 22;
		boolean res = new MainTest().hasPathSum(root, sum);
		System.out.println(res);
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		return dfs(root, sum, 0, false);
	}
	public static boolean dfs(TreeNode root, int sum, int cnt, boolean flag) {
		if(flag == true || root == null) {
			return flag;
		}
		cnt += root.val;
		if(cnt == sum && root.left == null && root.right == null) {
			//这个判断不能放在cnt加和之前
			//如果放在cnt之前，判断的是直到root的上一个结点的路径和情况，不是当前root结点的情况
			flag = true;
			return flag;
		}
		flag = dfs(root.left, sum, cnt, flag);
		flag = dfs(root.right, sum, cnt, flag);
		return flag;
	}
	
	public TreeNode createTree(TreeNode root) {
/*		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = null;
		root.left.left = null;
		root.left.right = null;
		return root;*/
		root = new TreeNode(5);
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
		return root;
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
