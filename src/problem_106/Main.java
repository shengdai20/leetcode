package problem_106;

public class Main {

	public static void main(String[] args) {
		int[] postorder = {9, 15, 7, 20, 3};
		int[] inorder = {9, 3, 15, 20, 7};
		TreeNode res = new Main().buildTree(inorder, postorder);
		new Main().print(res);
		System.out.println(res.left);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length == 0 || inorder.length == 0) {
			return null;
		}
		return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}
	private TreeNode dfs(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
		TreeNode root = new TreeNode(postorder[postR]);
		int rootIndex = inL;
		while(inorder[rootIndex] != postorder[postR]) {
			rootIndex++;
		}
		int leftLen = rootIndex - inL;
		int rightLen = inR - rootIndex;
		if(leftLen != 0) {
			root.left = dfs(inorder, postorder, inL, rootIndex - 1, postL, postL + leftLen - 1);
		}
		else {
			root.left = null;
		}
		if(rightLen != 0) {
			root.right = dfs(inorder, postorder, rootIndex + 1, inR, postL + leftLen, postR - 1);
		}
		else {
			root.right = null;
		}
		return root;
	}
	
	private void print(TreeNode root) {
		if(root != null) {
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
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