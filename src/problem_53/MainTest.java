package problem_53;

public class MainTest {

	public static void main(String[] args) {
	//	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = {-2, -1};
	//	int[] nums = {1};
		int res = new MainTest().maxSubArray(nums);
		System.out.println(res);
	}
	
	public int maxSubArray(int[] nums) {
/*		int res = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			int cnt = 0;
			//对于每一个数值，判断其后面的连续子序列和得到最大值
			for(int j = i; j < nums.length; j++) {
				cnt += nums[j];
				if(cnt > res) {
					res = cnt;
				}
			}
		}
		return res;*/
		//法一
/*		
		//这里要把res赋值为最小值，以防序列中负数的出现
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(sum < 0) {
				sum = nums[i];//如果当前值前面的sum<0，则将sum重新赋值为当前值，以此值为新的起点开始计算最大和
			}
			else {
				sum += nums[i];//否则， 将当前值加入sum中
			}
			if(sum > res) {
				res = sum;
			}
		}
		return res;*/
		//法二
		//结论：如果a[i]是负的，那么它不可能代表最优序列的起点，因为任何包含a[i]的作为起点的子序列都可以通过a[i+1]作起点而得到改进。类似地，任何负的子序列不可能是最优子序列的前缀
		//如果在内循环中检测到从a[i]到a[j]的子序列是负的，那么可以推进i到j+1。
		//在这里的运用也就是当sum<0时，即刻将sum重置为0。
		//这里一定要把res赋值为最小值，因为序列中会有负数的情况
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];//System.out.println(sum);
			if(sum > res) {
				res = sum;
			}
			//这里不要用else，因为类似序列{-2,-1}这种就计算不到最后的解
			if(sum < 0) {//如果sum<0，则将sum重置，也就是发现sum<0，则说明此序列不会是最大和序列
				sum = 0;
			}
		}
		return res;
	}
}
