package problem_113;

import java.util.ArrayList;
import java.util.List;

public class DfsTest {

	public static void main(String[] args) {
		TreeNode root = null;
		root = new MainTest().createTree(root);
		int sum = 22;
		List<List<Integer>> ans = new DfsTest().pathSum(root, sum);
		System.out.println(ans);
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> listIn = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		int cnt = 0;
		list = dfs(root, list, listIn, sum, cnt);
		return list;
	}
	public static List<List<Integer>> dfs(TreeNode root, List<List<Integer>> list, List<Integer> listIn, int sum, int cnt) {
		listIn.add(root.val);
		cnt += root.val;
		if(root.left == null && root.right == null) {
			if(cnt == sum) {
				list.add(new ArrayList<Integer>(listIn));
			}
			return list;
		}
		if(root.left != null) {
			list = dfs(root.left, list, listIn, sum, cnt);
			//需要回溯remove，因为list是集合，在任何一处的修改都会修改原值，所以需要回溯后删除
			listIn.remove(listIn.size() - 1);
			//不需要回溯减，因为cnt是基本类型，传进去后的修改，并不会对原值有任何改变
			//所以return后也不需要回溯，不然就多减了
		//	cnt -= root.val;
		}
		if(root.right != null) {
			list = dfs(root.right, list, listIn, sum, cnt);
			listIn.remove(listIn.size() - 1);
		//	cnt -= root.val;
		}
		return list;
	}
}
