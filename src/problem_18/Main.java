package problem_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	//	int[] nums = {1, 0, -1, 0, -2, 2};
		int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
		int target = 0;
		List<List<Integer>> res = new Main().fourSum(nums, target);
		System.out.println(res);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length - 3; i++) {
			//去除重复值
			if(i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < nums.length - 2; j++) {
				int left = j + 1, right = nums.length - 1;
				while(left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if(sum < target) {
						left++;
					}
					else if(sum > target) {
						right--;
					}
					else {
						List<Integer> listIn = new ArrayList<Integer>();
						listIn.add(nums[i]);
						listIn.add(nums[j]);
						listIn.add(nums[left]);
						listIn.add(nums[right]);
						res.add(listIn);
						//去除重复值
						while(left < right && nums[left] == nums[left + 1]) {
							left++;
						}
						while(left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						left++;
						right--;
					}
				}
				//去除重复值
				while(j + 1 < nums.length - 2 && nums[j] == nums[j + 1]) {
					j++;
				}
			}
		}
		return res;
	}
	
}
