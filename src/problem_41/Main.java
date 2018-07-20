package problem_41;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		int[] nums = {7, 8, 9, 11, -1};
	//	int[] nums = {0, 2, 2, 1, 1};
		int res = new Main().firstMissingPositive(nums);
		System.out.println(res);
	}

	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while(i < nums.length) {
			//把nums[i]放入i+1
			//其中nums[i]负数、nums[i]超过nums的总个数，nums[i]已经是i+1，这三种情况下，不需要进行替换
			if(nums[i] > 0 && nums[i] != i + 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
			else {
				i++;
			}
		}
		//最后得到的数组一定是在满足条件的情况下的下标中，nums[i]=i+1，遍历即可
		//比如{0,2,2,1,1}最后得到的数组一定是{1,2,2,0,1}
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != j + 1) {
				return j + 1;
			}
		}
		return nums.length + 1;
	}
	
/*	public int firstMissingPositive(int[] nums) {
		if(nums.length == 0) {
			return 1;
		}
		//存入set集合
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		//从1开始遍历set集合
		int cnt = 1;
		while(true) {
			if(set.contains(cnt)) {
				cnt++;
			}
			else {
				return cnt;
			}
		}
	}*/
}
