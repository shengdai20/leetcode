package problem_77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		List<List<Integer>> list = new MainTest().combine(4, 2);
		System.out.println(list);
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(res, tmp, n, k, 1);
		return res;
	}
	public static void dfs(List<List<Integer>> res, List<Integer> tmp, int n, int k, int start) {
		if(tmp.size() == k) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i = start; i <= (n - (k - tmp.size()) + 1); i++) {
			//i <= (n - (k - tmp.size()) + 1)剪枝，当可选的数已经不够时，直接剪枝
			tmp.add(i);
			dfs(res, tmp, n, k, i + 1);
			tmp.remove(tmp.size() - 1);//回溯删除
		}
	}
	
/*	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for(int i = 1; i <= n; i++) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for(List<Integer> r : res) {
				List<Integer> a = new ArrayList<Integer>(r);
				a.add(i);
				tmp.add(a);
			}
			res.addAll(tmp);
		}
		//从所有集合中拿到个数是k的子集合加到结果集中
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(List<Integer> r : res) {
			if(r.size() == k) {
				list.add(r);
			}
		}
		return list;
	}*/
	
/*	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(res, tmp, n, k, 1);
		return res;
	}
	public static void dfs(List<List<Integer>> res, List<Integer> tmp, int n, int k, int start) {
	//	System.out.println(tmp);
		if(tmp.size() == k) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i = start; i <= n; i++) {
			tmp.add(i);
			dfs(res, tmp, n, k, i + 1);
			tmp.remove(tmp.size() - 1);//回溯删除
		}
	}*/
}
