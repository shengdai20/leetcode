package problem_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainTest {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = new MainTest().combinationSum2(candidates, target);
		System.out.println(res);
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);//先进行排序
		dfs(res, tmp, candidates, target, 0);
		return res;
	}
	public static boolean dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start) {
		if(target < 0) {
			return false;
		}
		if(target == 0) {//递归结束条件
			res.add(new ArrayList<Integer>(tmp));
			return false;
		}
		else {//这里一定要判断target>0，因为如果不判断就会导致target<0时还在往下递归
			for(int i = start; i < candidates.length; i++) {
				//去重
				if(i > start && candidates[i] == candidates[i - 1]) {
					continue;
				}
				tmp.add(candidates[i]);
				boolean flag = dfs(res, tmp, candidates, target - candidates[i], i + 1);//这里是i，因为不能重复选
				tmp.remove(tmp.size() - 1);
				//剪枝，因为数组是排好序的，所以一旦总和<=0，那么其后的数字一定会导致当前结果<0，所以可以直接从此跳过后面的循环
				if(flag == false) {
					break;
				}
			}
		}
		return true;
	}
}
