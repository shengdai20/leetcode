package problem_108;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		TreeNode root = new MainTest().sortedArrayToBST(nums);
		System.out.println(root.val);
		new MainTest().print(root);
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return dfs(nums, 0, nums.length - 1);
	}
	
	public static TreeNode dfs(int[] nums, int left, int right) {
		if(left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(nums, left, mid - 1);
		root.right = dfs(nums, mid + 1, right);
		return root;
	}
	
	public void print(TreeNode root) {
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