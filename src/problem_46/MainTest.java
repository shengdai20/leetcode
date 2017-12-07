package problem_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> list = new MainTest().permute(nums);
		System.out.println(list);
	}

/*	public List<List<Integer>> permute(int[] nums) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		res.add(new ArrayList<Integer>());//加一个空的list进去，以保证下面size在第一次的时候就为1，从而保证后面的计算
		for(int n : nums) {//遍历nums数组值
			for(int size = res.size(); size > 0; size--) {//查看结果集res中已经包含几个序列
				List<Integer> tmp = res.pollFirst();//取出结果集res中的每个序列
				for(int i = 0; i <= tmp.size(); i++) {//对于取出的序列，在每一个位置都尝试加入当前nums数组值，这里的i表示当前取出序列的第i位，比如取出的序列是1，接下来就要在1之前及1之后加入2
					List<Integer> resIn = new ArrayList<Integer>(tmp);//每一个位置都新初始化刚取出的序列，这样保证能在原始取出序列的基础上增添数值
					resIn.add(i, n);//在第i位加入数值n
					System.out.println(resIn);
					res.add(resIn);//这里因为每从结果集中取出一个序列就是清空一个序列，所以这里add的时候就是一个全新的序列
				}
			}
		}
		return res;
	}*/
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(list, nums, tmp);
		return list;
	}
	public static void dfs(List<List<Integer>> list , int[] nums, List<Integer> tmp) {
		System.out.println(tmp);
		if(tmp.size() == nums.length) {
			if(!list.contains(tmp))
				list.add(new ArrayList<Integer>(tmp));//这里一定要用new之后再加入到list中，否则list集合会是空值
			return;
		}
		for(int i =0 ; i < nums.length; i++) {
			if(!tmp.contains(nums[i])) {
				tmp.add(nums[i]);
				dfs(list, nums, tmp);
				tmp.remove(tmp.size() - 1);//删除最后一个元素
			}
		}
	}
}
