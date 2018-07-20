package problem_75;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] nums = {2, 0, 2, 1, 1, 0};
		new Main().sortColors(nums);
		for(int num : nums) {
			System.out.println(num);
		}
	}
	
	public void sortColors(int[] nums) {
		int cnt0 = -1, cnt1 = -1, cnt2 = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				nums[++cnt2] = 2;
				nums[++cnt1] = 1;
				nums[++cnt0] = 0;
			} 
			else if(nums[i] == 1) {
				nums[++cnt2] = 2;
				nums[++cnt1] = 1;
			}
			else {
				nums[++cnt2] = 2;
			}
		}
	}
	
/*	public void sortColors(int[] nums) {
		int red = 0, blue = nums.length - 1;
		for(int i = 0; i <= blue; i++) {
			//如果当前是red，则将当前元素交换到前面，red位置后移一位
			if(nums[i] == 0) {
				int tmp = nums[i];
				//这里不需要回退遍历，因为将0换到前面，肯定不会导致2还排在0的前面遍历不到的情况。
				nums[i] = nums[red];
				nums[red++] = tmp;
			}
			//如果当前是blue，则将当前元素交换到后面，blue位置前移一位
			else if(nums[i] == 2) {
				int tmp = nums[i];
				//这里i--是必须的，因为有可能出现1，2，0的情况，将0换到2的前面，而如果不再遍历0的话，就会导致错误，所以换2之后，需要回退遍历一下
				nums[i--] = nums[blue];
				nums[blue--] = tmp;
			}
		}
	}*/

/*	public void sortColors(int[] nums) {
		int cnt0 = 0, cnt1 = 0, cnt2 = 0;
		//第一遍遍历计数
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				cnt0++;
			}
			else if(nums[i] == 1) {
				cnt1++;
			}
			else {
				cnt2++;
			}
		}
		//第二遍遍历重写数组
		int k = 0;
		for(int i = 0; i < cnt0; i++) {
			nums[k++] = 0;
		}
		for(int i = 0; i < cnt1; i++) {
			nums[k++] = 1;
		}
		for(int i = 0; i < cnt2; i++) {
			nums[k++] = 2;
		}
	}*/
	
/*	public void sortColors(int[] nums) {
		Arrays.sort(nums);
	}*/
}
