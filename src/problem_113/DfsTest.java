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
		int cnt = 0;
		list = dfs(root, list, listIn, sum, cnt);
		return list;
	}
	public static List<List<Integer>> dfs(TreeNode root, List<List<Integer>> list, List<Integer> listIn, int sum, int cnt) {
		listIn.add(root.val);
		cnt += root.val;
		if(root.left == null && root.right == null) {
			System.out.println(listIn + "//" + cnt);
			if(cnt == sum) {System.out.println(listIn);
				list.add(new ArrayList<Integer>(listIn));
			}
			return list;
		}
		if(root.left != null) {
			list = dfs(root.left, list, listIn, sum, cnt);
			listIn.remove(listIn.size() - 1);
			cnt -= root.val;
		}
		if(root.right != null) {
			list = dfs(root.right, list, listIn, sum, cnt);
			listIn.remove(listIn.size() - 1);
			cnt -= root.val;
		}
		return list;
	}
}
