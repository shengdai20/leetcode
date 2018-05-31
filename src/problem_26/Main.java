package problem_26;

public class Main {

	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		int res = new Main().removeDuplicates(nums);
		System.out.println(res);
	}
	
	public int removeDuplicates(int[] nums) {
		int k = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i - 1]) {
				nums[k++] = nums[i];
			}
		}
		return k;
	}

}
