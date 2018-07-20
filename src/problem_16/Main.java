package problem_16;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		int res = new Main().threeSumClosest(nums, target);
		System.out.println(res);
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = 0, res = 0, diff = 0, mi = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			while(left < right) {
				sum = nums[i] + nums[left] + nums[right];
				diff = Math.abs(sum - target);
				if(diff < mi) {
					mi = diff;
					res = sum;
				}
				if(sum < target) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		return res;
	}
}
