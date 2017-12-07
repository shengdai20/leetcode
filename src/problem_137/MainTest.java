package problem_137;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,2,1,2,3,5,5,5};
		int ans = new MainTest().singleNumber(nums);
		System.out.println(ans);
	}
	
	public int singleNumber(int[] nums) {
		int ans = 0;
		int length = nums.length;
		//将每一个数取二进制位按位相加，如果都是重复的则当前位的相加和一定是3的倍数，否则当前位一定存在于要找的那个数中
		//比如1，1，1，2，2，2，3这六个数将其转为二进制数按位相加，然后每一位都对3取模，最后一定可以得到3
		for(int i = 0; i < 32; i++) {//计算每一位
			int sum = 0;//统计每一位的和
			for(int j = 0; j < length; j++) {//对每个数取第i位的数值
				if(((nums[j] >> i) & 1) == 1) {//取第i位的数值
					sum++;//将每个数第i位的值相加求和
					sum %= 3;
				}
			}
			if(sum != 0) {//如果对3取模后非0，则说明当前位一定是要找的数的某一位
				ans |= sum << i;//将其转为十进制加入结果当中
			}
		}
		return ans;
	}
	
/*	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int ans = nums[0];
		int cnt = 1;
		int length = nums.length;
		for(int i = 1; i < length; i++) {
			if(nums[i] != nums[i - 1]) {
				if(cnt == 1) {
					break;
				}
				ans = nums[i];
				cnt = 1;
			}
			else {
				cnt++;
			}
		}
		return ans;
	}*/
	
/*	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ans = -1;
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(map.get(nums[i]) == 1) {
				ans = nums[i];
				break;
			}
		}
		return ans;
	}*/
}
