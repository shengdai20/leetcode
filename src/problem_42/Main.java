package problem_42;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int res = new Main().trap(height);
		System.out.println(res);
	}
	
	//两个指针
	//定义两个指针，左指针与右指针的值进行比较，记录较小者，如果左指针较小，则从左往右遍历，如果右指针较小，则从右往左遍历，如果遍历到的值比较小者小，则表示可以蓄水：较小者-当前值
	public int trap(int[] height) {
		int left = 0, right = height.length - 1, mi = 0, res = 0;
		while(left < right) {
			//如果左指针较小，从左往右遍历
			if(height[left] < height[right]) {
				mi = height[left++];
				while(left < right && height[left] < mi) {
					res += mi - height[left++];
				}
			}
			//如果右指针较小，从右往左遍历
			else {
				mi = height[right--];
				while(left < right && height[right] < mi) {
					res += mi - height[right--];
				}
			}
		}
		return res;
	}
	
	//stack
	//入栈递减高度，当当前高度>s.peek()时，可以蓄水，栈顶第一个元素为坑最低高度，栈顶第二个元素为左边界，当前高度为右边界，坑深为min(左高度，右高度)-坑最低高度
/*	public int trap(int[] height) {
		Stack<Integer> s = new Stack<Integer>();
		int res = 0;
		for(int i = 0; i < height.length; i++) {
			//循环查找在当前高度下，是否可以蓄水
			while(!s.isEmpty() && height[i] > height[s.peek()]) {
				int cur = s.pop();
				//如果栈空，说明没有左边界，没法蓄水，所以直接break
				if(s.isEmpty()) {
					break;
				}
				//计算蓄水，此时不再是按照前面的方法，分点计算竖状蓄水能力，而是按照整块的蓄水能力计算的，也就是普通思维的按照蓄水池的长*宽来计算的
				res += (i - s.peek() - 1) * (Math.min(height[s.peek()], height[i]) - height[cur]);
			}
			//如果比栈顶高度小，压栈
			s.push(i);
		}
		return res;
	}*/
	
	//dp
/*	public int trap(int[] height) {
		int dp[] = new int[height.length];
		int ma = 0, res = 0;
		//记录i值左边的最大高度
		for(int i = 0; i < height.length; i++) {
			dp[i] = ma;
			//更新左边最大高度
			ma = Math.max(ma, height[i]);
		}
		//更新计算i值右边的最大高度
		ma = 0;
		for(int i = height.length - 1; i >= 0; i--) {
			//在左边和右边最大高度中取较小者
			dp[i] = Math.min(dp[i], ma);
			//更新右边
			ma = Math.max(ma, height[i]);
			//如果两边高度比当前高度高，则表示可以蓄水
			if(dp[i] > height[i]) {
				res += dp[i] - height[i];
			}
		}
		return res;
	}*/
	
	//暴力
/*	public int trap(int[] height) {
		int res = 0;
		for(int i = 0; i < height.length; i++) {
			int left = height[i], right = height[i];
			//找左边最大高度
			for(int j = i - 1; j >= 0; j--) {
				left = Math.max(left, height[j]);
			}
			//找右边最大高度
			for(int j = i + 1; j < height.length; j++) {
				right = Math.max(right, height[j]);
			}
			//计算蓄水
			res += Math.min(left, right) - height[i];
		}
		return res;
	}*/

}
