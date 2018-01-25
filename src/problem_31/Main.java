package problem_31;

public class Main {

	public static void main(String[] args) {
		int[] nums = {2, 3, 1};
		new Main().nextPermutation(nums);
		
	}
	
	public void nextPermutation(int[] nums) {
		int length = nums.length;
		int pre = 0, post = 0;//pre标记前面的第一个小数，即nums[pre]<nums[pre+1]，post标记后面的第一个大数，即nums[post]>nums[pre]
		boolean mark = false;//标记是否是降序序列
		//从后往前找，找到第一个前面的数小于后面的数的下标
		for(int i = length - 1; i > 0; i--) {
			if(nums[i - 1] < nums[i]) {
				mark = true;
				pre = i - 1;
				break;
			}
		}
		//从后往前找，找到第一个比前面标记的数大的数的下标
		for(int i = length - 1; i > 0; i--) {
			if(nums[i] > nums[pre]) {
				post = i;
				break;
			}
		}
		int mid = (length - pre - 1) / 2;
		//如果直接是降序，直接反转即可
		if(mark == false) {
			for(int i = pre; i <= (pre + mid); i++) {
				int t = nums[i];
				nums[i] = nums[--length];
				nums[length] = t;
			}
/*			for(int i = 0; i < nums.length; i++) {
				System.out.println(nums[i]);
			}*/
			return;
		}
		int tmp = nums[pre];
		nums[pre] = nums[post];
		nums[post] = tmp;
		//反转后面的降序序列为升序序列
		for(int i = pre + 1; i <= (pre + mid); i++) {
			int t = nums[i];
			nums[i] = nums[--length];
			nums[length] = t;
		}
/*		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}*/
	}

}
