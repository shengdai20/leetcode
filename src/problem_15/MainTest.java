package problem_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
	//	int[] nums = {-1, 0, 1, 2, -1, -4};
		int[] nums = {-2, 0, 1, 1, 2}; 
	//	int[] nums = {-1, -1, -1, 1};
		List<List<Integer>> res = new MainTest().threeSum(nums);
		System.out.println(res);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		int cnt = 0;
		//排序
		Arrays.sort(nums);
		int low = 0, high = 0, length = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < length - 2; i++) {
			//因为不能有重复结果，如果第一个数值相同，剪枝
			if(i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(low = i + 1, high = length - 1; low < high; ) {
				cnt = nums[low] + nums[high] + nums[i];
				if(cnt > 0) {
					high--;
				}
				else if(cnt < 0) {
					low++;
				}
				else {
					List<Integer> listIn = new ArrayList<Integer>();
					listIn.add(nums[i]);
					listIn.add(nums[low]);
					listIn.add(nums[high]);
					res.add(listIn);
					//剪枝，跳过重复数值
					while(low < high && nums[low] == nums[low + 1]) {
						low++;
					}
					while(low < high && nums[high] == nums[high - 1]) {
						high--;
					}
					low++;
					high--;
				}
			}
		}
		return res;
	}
}
