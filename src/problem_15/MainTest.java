package problem_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = new MainTest().threeSum(nums);
		System.out.println(res);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(res, tmp, nums, 0, 0, 0);
		return res;
	}
	public static void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start, int cnt, int num) {
//		System.out.println(tmp);
		if(cnt == 3) {
			if(num == 0)
				res.add(new ArrayList<Integer>(tmp));
			return;
		}
		else {
			for(int i = start; i < nums.length; i++) {
				//去重
				if(i > start && nums[i] == nums[i - 1]) {
					continue;
				}
				//剪枝
				if(num + nums[i] > 0) {
					break;
				}
				if(cnt == 2) {
					if(num + nums[i] < 0) {
						continue;
					}
				}
				
				tmp.add(nums[i]);
				dfs(res, tmp, nums, i + 1, cnt + 1, num + nums[i]);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
