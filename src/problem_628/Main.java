package problem_628;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] nums = {-1, -2, -3, -4, -5, 1, 2, 3, 4, 5};
		int res = new Main().maximumProduct(nums);
		System.out.println(res);
	}

	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int mi1 = nums[0];
		int mi2 = nums[1];
		int res = 0;
		//取左边两个负数和右边最大正数
		if(nums[nums.length - 2] * nums[nums.length - 3] < mi1 * mi2) {
			res = mi1 * mi2 * nums[nums.length - 1];
		}
		//取右边最大的三个正数
		else {
			res = nums[nums.length - 2] * nums[nums.length - 3] * nums[nums.length - 1];
		}
		return res;
	}
}
