package problem_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int[] candidates = {8,7,4,3};
		int target = 11;
		List<List<Integer>> res = new MainTest().combinationSum(candidates, target);
		System.out.println(res);
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res, tmp, candidates, target, 0);
        return res;
    }
    public static void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start) {
        if(target == 0) {//递归结束条件
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        else if(target > 0){//这里一定要判断target>0，因为如果不判断就会导致target<0时还在往下递归
            for(int i = start; i < candidates.length; i++) {
            	//快速剪枝
            	if(target < candidates[i]) {
            		break;
            	}
                tmp.add(candidates[i]);
                dfs(res, tmp, candidates, target - candidates[i], i);//这里不是i+1而是i，因为可以重复选
                tmp.remove(tmp.size() - 1);
            }
        }
    }
/*	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
				tmp.add(candidates[i]);
				boolean flag = dfs(res, tmp, candidates, target - candidates[i], i);//这里不是i+1而是i，因为可以重复选
				tmp.remove(tmp.size() - 1);
				//剪枝，因为数组是排好序的，所以一旦总和<=0，那么其后的数字一定会导致当前结果<0，所以可以直接从此跳过后面的循环
				if(flag == false) {
					break;
				}
			}
		}
		return true;
	}*/
}
