package problem_45;

public class Main {

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		int res = new Main().jump(nums);
		System.out.println(res);
	}

	public int jump(int[] nums) {
		int cur = 0, res = 0, pre = 0;
		for(int i = 0; i < nums.length; i++) {
			//如果当前位置超过了上一次可以达到的最远距离，更新跳数和上一次可达到的最远距离
			if(i > pre) {
				pre = cur;
				res++;
			}
			//更新当前最远距离
			cur = Math.max(cur, i + nums[i]);
		}
		return res;
	}
}
