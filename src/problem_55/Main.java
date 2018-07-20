package problem_55;

public class Main {

	public static void main(String[] args) {
	//	int[] nums = {3, 0, 8, 2, 0, 0, 1};
	//	int[] nums = {2, 5, 0, 0};
	//	int[] nums = {2, 0, 0};
	// 	int[] nums = {2, 3, 1, 1, 4};
	//	int[] nums = {3, 2, 1, 0, 4};
	//	int[] nums = {0, 1};
	//	int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
		int[] nums = {5, 4, 0, 2, 0, 1, 0, 1, 0};
		boolean res = new Main().canJump(nums);
		System.out.println(res);
	}
	
	
	public boolean canJump(int[] nums) {
		int ma = 0;
		for(int i = 0; i < nums.length; i++) {
			//如果最远距离小于当前位置，表示当前位置不可达
			if(i > ma || ma >= nums.length - 1) {
				break;
			}
			//更新最远距离
			ma = Math.max(ma, i + nums[i]);
		}
		return ma >= nums.length - 1;
	}
	
/*	public boolean canJump(int[] nums) {
		//dp[i]表示从上一个位置走到当前位置i时，还剩余的可往前走的步数是多少
		int[] dp = new int[nums.length];
		//dp[i] = max(dp[i- 1], nums[i - 1]) - 1
		for(int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
			if(dp[i] < 0) {
				return false;
			}
		}
		return true;
	}*/
}
