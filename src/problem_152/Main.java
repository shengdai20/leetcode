package problem_152;

public class Main {

	public static void main(String[] args) {
		int[] nums = {2, 3, -2, 4};
		int res = new Main().maxProduct(nums);
		System.out.println(res);
	}

	public int maxProduct(int[] nums) {
		int res = nums[0], ma = nums[0], mi = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] <= 0) {
				int t = ma;
				ma = mi;
				mi = t;
			}
			ma = Math.max(ma * nums[i], nums[i]);
			mi = Math.min(mi * nums[i], nums[i]);
			res = Math.max(ma, res);
		}
		return res;
	}
	
/*	public int maxProduct(int[] nums) {
		int res = nums[0], ma = nums[0], mi = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > 0) {
				ma = Math.max(ma * nums[i], nums[i]);
				mi = Math.min(mi * nums[i], nums[i]);
			}
			//注意负数或0的情况
			else {
				int t = ma;
				ma = Math.max(mi * nums[i], nums[i]);
				mi = Math.min(t * nums[i], nums[i]);
			}
			res = Math.max(res, ma);
		}
		return res;
	}*/
	
	//两次遍历
/*	public int maxProduct(int[] nums) {
		int res = Integer.MIN_VALUE, sum = 1;
		//正向遍历，取最大值
		for(int i = 0; i < nums.length; i++) {
			sum *= nums[i];
			res = Math.max(res, sum);
			if(nums[i] == 0) {
				sum = 1;
			}
		}
		//反向遍历，取最大值
		sum = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			sum *= nums[i];
			res = Math.max(res, sum);
			if(nums[i] == 0) {
				sum = 1;
			}
		}
		return res;
	}*/
	
/*	public int maxProduct(int[] nums) {
		int dp_max[] = new int[nums.length];
		int dp_min[] = new int[nums.length];
		int res = Integer.MIN_VALUE;
		dp_max[0] = nums[0];
		dp_min[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			//更新最大值数组
			dp_max[i] = Math.max(Math.max(dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i]), nums[i]);
			//更新最小值数组
			dp_min[i] = Math.min(Math.min(dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i]), nums[i]);
			res = Math.max(dp_max[i], res);
		}
		return res;
	}*/
	
	//暴力
/*	public int maxProduct(int[] nums) {
		int res = Integer.MIN_VALUE, len = nums.length;
		for(int i = 0; i < len; i++) {
			int sum = 1;
			for(int j = i; j < len; j++) {
				sum *= nums[j];
				res = Math.max(res, sum);
			}
		}
		return res;
	}*/
}
