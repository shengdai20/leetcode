package problem_105;

public class Main {

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.left.left = null;
//		root.left.right = null;
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
//		root.right.left.left = null;
//		root.right.left.right = null;
//		root.right.right.left = null;
//		root.right.right.right = null;
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		TreeNode res = new Main().buildTree(preorder, inorder);
		new Main().print(res);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	//preL是当前先序数组的第一个结点下标，preR是当前先序数组的最后一个结点下标
	//inL是当前后序数组的第一个结点下标，inR是当前后序数组的最后一个结点下标
	private TreeNode dfs(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
		//将当前先序数组的第一个结点加入二叉树中，这个结点其实就是当前子树的根节点
		TreeNode root = new TreeNode(preorder[preL]);
		//根据这个根节点，去中序数组中找到位置下标
		int rootIndex = inL;
		while(inorder[rootIndex] != preorder[preL]) {
			rootIndex++;
		}
		//左子树长度，根据当前中序数组和刚才确定的根节点下标，计算左子树长度，即中序数组中根节点前面的则是左子树
		int leftLen = rootIndex - inL;
		//右子树长度，根据当前中序数组和刚才确定的根节点下标，计算右子树长度，即中序数组中根节点后面的则是右子树
		int rightLen = inR - rootIndex;
		if(leftLen != 0) {
			//确定左子树
			root.left = dfs(preorder, inorder, preL + 1, preL + leftLen, inL, inL + leftLen - 1);
		}
		else {
			root.left = null;
		}
		if(rightLen != 0) {
			//确定右子树
			root.right = dfs(preorder, inorder, preR - rightLen + 1, preR, inR - rightLen + 1, inR);
		}
		else {
			root.right = null;
		}
		return root;
	}
	
	private void print(TreeNode root) {
		if(root != null) {
			print(root.left);
			print(root.right);
			System.out.println(root.val);
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
