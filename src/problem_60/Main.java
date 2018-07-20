package problem_60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int n = 4, k = 9;
		String res = new Main().getPermutation(n, k);
		System.out.println(res);
	}
	
	public String getPermutation(int n, int k) {
		List<Integer> num = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			num.add(i);
		}
		int[] fact = new int[n];
		fact[0] = 1;
		//计算阶层
		for(int i = 1; i < n; i++) {
			fact[i] = i * fact[i - 1];
		}
		k = k - 1;
		//由于要经常+字符串，所以弃用String，这样可以加快效率
		StringBuilder res = new StringBuilder();
		for(int i = n; i > 0; i--) {
			//第i位应该放置的第pos个数，这个pos是原1-n中的位置
			int pos = k / fact[i - 1];
			k = k % fact[i - 1];
			//正确放置
			res.append(num.get(pos));
			//已经放置过了就删除
			num.remove(pos);
		}
		return res.toString();
	}
	
/*	public String getPermutation(int n, int k) {
		List<Integer> tmp = new ArrayList<Integer>();
		String res = "";
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		res = dfs(list, n, k, tmp, res);
		return res;
	}
	public static String dfs(List<List<Integer>> list, int n, int k, List<Integer> tmp, String res) {
		if(list.size() > k) {
			return res;
		}
		if(tmp.size() == n) {
			list.add(new ArrayList<Integer>(tmp));
			if(list.size() == k) {
				for(int i = 0; i < tmp.size(); i++) {
					res += tmp.get(i);
				}
			}
			return res;
		}
		for(int i = 1; i <= n; i++) {
			if(!tmp.contains(i)) {
				tmp.add(i);
				res = dfs(list, n, k, tmp, res);
				tmp.remove(tmp.size() - 1);
			}
		}
		return res;
	}*/

}

