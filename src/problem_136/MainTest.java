package problem_136;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainTest {

	public static void main(String[] args) {
		int[] nums = {1, 1, 3, 3, 4, 8, 9, 8, 9};
		int res = singleNumber(nums);
		System.out.println(res);
	}
	
	public static int singleNumber(int[] nums) {
/*		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = -1;
		for(int i = 0; i < nums.length; i++) {
			if(map.get(nums[i]) != null && map.get(nums[i]) == 1) {
				map.put(nums[i], 2);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(map.get(nums[i]) == 1) {
				res = nums[i];
				break;
			}
		}
		return res;*/
/*		Arrays.sort(nums);
		int res = nums[0];
		int cnt = 1;
		boolean flag = false;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i - 1]) {
				if(cnt == 1) {
					res = nums[i - 1];
					flag = true;
					break;
				}
				cnt = 1;
			}
			else {
				cnt++;
			}
		}
		if(flag == false) {
			res = nums[nums.length - 1];
		}
		return res;*/
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
 	}
}
