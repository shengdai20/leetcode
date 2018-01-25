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
		int length = nums.length, pos = 0;
		if(length == 1) {
			return true;
		}
		int[] mark = new int[length];
		for(int i = 0; i < length; i++) {
			mark[i] = 0;
		}
		for(int i = 0; i < length; ) {
			pos += nums[i];
			mark[i] = 1;
			while(((pos >= length) || (pos == i) || (pos > 0 && nums[pos] == 0))) {
				if(pos == length - 1) {
					break;
				}
				pos--;
		//		System.out.println(i + "," + pos);
			}
			if(pos >= length - 1 || pos < 0) {
				break;
			}
			if(mark[pos] == 1) {
				i--;
				if(mark[i] == 1) {
					break;
				}
				continue;
			}
			i = pos;
		}
		if(pos == length - 1) {
			return true;
		}
		return false;
	}
}
