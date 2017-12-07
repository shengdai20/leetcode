package problem_53;

public class DivideConquerTest {

	public static void main(String[] args) {
	//	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = {-2, -1};
	//	int[] nums = {1};
		int res = new DivideConquerTest().maxSubArray(nums);
		System.out.println(res);
	}
	
	public int maxSubArray(int[] nums) {
		return solution(nums, 0, nums.length - 1);
	}
	
	public int solution(int[] a, int left, int right) {
		//处理left==right中间值情况
		if(left == right) {
			return a[left];
		}
		
		int mid = (left + right) / 2;
		//递归求左边最大和
		int maxLeft = solution(a, left, mid);
		//递归求右边最大和
		int maxRight = solution(a, mid + 1, right);
		
		//当前数组左边包含最后一个数的最大和
		int maxLeftSum = Integer.MIN_VALUE;
		int leftSum = 0;
		for(int i = mid; i >= left; i--) {
			leftSum += a[i];
			if(maxLeftSum < leftSum) {
				maxLeftSum = leftSum;
			}
		}
		
		//当前数组右边包含第一个数的最大和
		int maxRightSum = Integer.MIN_VALUE;
		int rightSum = 0;
		for(int i = mid + 1; i <= right; i++) {
			rightSum += a[i];
			if(maxRightSum < rightSum) {
				maxRightSum = rightSum;
			}
		}
		
		//左边最大和，右边最大和，包含左右两边的最大和，返回这三个值中的最大值
		int tmp = maxLeft > maxRight ? maxLeft : maxRight;
		return tmp > (maxLeftSum + maxRightSum) ? tmp : (maxLeftSum + maxRightSum);
	}
}
