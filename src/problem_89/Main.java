package problem_89;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int n = 4;
		List<Integer> res = new Main().grayCode(n);
		System.out.println(res);
	}
	
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		int num = (int) Math.pow(2, n);
		for(int i = 0; i < num; i++) {
			//(i>>1)^i转换为格雷码
			res.add((i >> 1) ^ i);
		}
		return res;
	}
	
/*	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(res, 0, n, tmp);
		return res;
	}
	public static void dfs(List<Integer> res, int cnt, int n, List<Integer> tmp) {
		if(cnt == n) {
			int num = 0;
			for(int i = 0; i < n; i++) {
				num = num * 2 + tmp.get(i);
			}
			res.add(num);
			return;
		}
		tmp.add(0);
		dfs(res, cnt + 1, n, tmp);
		tmp.remove(tmp.size() - 1);
		tmp.add(1);
		dfs(res, cnt + 1, n, tmp);
		tmp.remove(tmp.size() - 1);
	}*/

}
