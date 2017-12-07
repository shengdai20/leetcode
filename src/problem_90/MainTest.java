package problem_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainTest {

	public static void main(String[] args) {
		int[] nums = {4, 4, 4, 1, 4};
		List<List<Integer>> list = new MainTest().subsetsWithDup(nums);
		System.out.println(list);
	}
	
/*	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(list, tmp, nums, 0);
		return list;
	}
	public static void dfs(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		if(!list.contains(tmp)) {
			list.add(new ArrayList<Integer>(tmp));
		}
		for(int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			dfs(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}*/
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(list, tmp, nums, 0);
		return list;
	}
	public static void dfs(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		list.add(new ArrayList<Integer>(tmp));
		for(int i = start; i < nums.length; i++) {
			//剪枝，这里i!=start还没怎么看懂，但是不能使用i>0的判断
			if(i != start && nums[i] == nums[i - 1]) {
				continue;
			}
			tmp.add(nums[i]);
			dfs(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
			
		}
	}
}

