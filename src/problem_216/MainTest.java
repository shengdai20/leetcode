package problem_216;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> res = new MainTest().combinationSum3(k, n);
		System.out.println(res);
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(res, tmp, k, n, 1);
		return res;
	}
	public static void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int start) {
		if(tmp.size() == k && n == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		else if(n > 0) {
			for(int i = start; i <= 9; i++) {
				//快速剪枝
				if(n < i) {
					break;
				}
				tmp.add(i);
				dfs(res, tmp, k, n - i, i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	
/*	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(res, tmp, k, n, 1);
		return res;
	}
	public static void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int start) {
		if(tmp.size() == k) {
			int num = 0;
			for(int i = 0; i < k; i++) {//计算和是否是n
				num += tmp.get(i);
			}
			if(num == n) {
				res.add(new ArrayList<Integer>(tmp));
			}
			return;
		}
		for(int i = start; i <= 9; i++) {
			tmp.add(i);
			dfs(res, tmp, k, n, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}*/
}
