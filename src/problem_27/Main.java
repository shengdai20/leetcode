package problem_27;

public class Main {

	public static void main(String[] args) {
		int[] nums = {3, 2, 3, 2};
		int val = 3;
		int res = new Main().removeElement(nums, val);
		System.out.println(res);
	}
	
	public int removeElement(int[] nums, int val) {
		int k = 0, i = 0;
		for( ; i < nums.length; i++) {
			if(nums[i] == val) {
				k++;
			}
			else {
				nums[i - k] = nums[i];
			}
		}
		return i - k;
	}
	
/*	public int removeElement(int[] nums, int val) {
		int k = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[k++] = nums[i];
			}
		}
		return k;
	}*/

}
