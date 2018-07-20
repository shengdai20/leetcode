package problem_80;

public class Main {

	public static void main(String[] args) {
	//	int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
		int[] nums = {1, 1, 1, 2, 2, 3};
		int res = new Main().removeDuplicates(nums);
		System.out.println(res);
	}
	
	public int removeDuplicates(int[] nums) {
		int k = 1;
		int cnt = 1;
		for(int i = 1; i < nums.length; i++) {
			//如果前后数相等
			if(nums[i] == nums[i - 1]) {
				//查看重复次数是否在2的范围内
				if(cnt < 2) {
					nums[k++] = nums[i];
					cnt++;
				}
				else {
					cnt++;
				}
			}
			//如果前后数不想等，放心保留，将计数器重置
			else {
				nums[k++] = nums[i];
				cnt = 1;
			}
		}
		return k;
	}

}
