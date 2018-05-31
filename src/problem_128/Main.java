package problem_128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		int[] nums = {0, 1, 1, 2};
		int res = new Main().longestConsecutive(nums);
		System.out.println(res);
	}
	
	public int longestConsecutive(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		for(int i = 0; i < nums.length; i++) {
			//如果已经存在，则继续遍历
			if(map.containsKey(nums[i])) {
				continue;
			}
			//找到当前值左连续的数值个数
			int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
			//找到当前值右连续的数值个数
			int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
			//计算当前值总连续的数值个数
			int sum = left + right + 1;
			//更新到map中
			map.put(nums[i], sum);
			//找最大值
			res = Math.max(res, sum);
			//这个是重点！！！更新左连续和右连续的数值个数，但是为啥不就近更新呢？比如说nums[i]-1，而要更新那么远的？
			map.put(nums[i] - left, sum);
			map.put(nums[i] + right, sum);
		}
		return res;
	}
	
/*	public int longestConsecutive(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		//排序
		Arrays.sort(nums);
		int cnt = 1, ma = 1;
		//逐一遍历
		for(int i = 1; i < nums.length; i++) {
			//去除重复值
			if(nums[i] == nums[i - 1]) {
				continue;
			}
			//如果连续
			else if(nums[i] == nums[i - 1] + 1) {
				cnt++;
			}
			//一旦不连续，更新ma和cnt
			else {
				if(cnt > ma) {
					ma = cnt;
				}
				cnt = 1;
			}
		}
		//由于可能整个数组一直连续，所以最后还应该再判断一下
		if(cnt > ma) {
			ma = cnt;
		}
		return ma;
	}*/

}
