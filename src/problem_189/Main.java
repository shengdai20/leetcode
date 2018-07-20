package problem_189;

public class Main {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 10;
		new Main().rotate(nums, k);
	}
	
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		//翻转前面的数组
		trueRotate(nums, 0, nums.length - k);
		//翻转后面的数组
		trueRotate(nums, nums.length - k, nums.length);
		//整体翻转
		trueRotate(nums, 0, nums.length);
	}
	//翻转数组
	public void trueRotate(int[] nums, int s, int e) {
		int mi = (s + e) / 2;
		for(int i = s; i < mi; i++) {
			int tmp = nums[i];
			nums[i] = nums[--e];
			nums[e] = tmp;
		}
	}
}
