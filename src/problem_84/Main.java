package problem_84;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
	//	int[] heights = {2, 1, 5, 6, 2, 3};
		int[] heights = {1, 1};
		int res = new Main().largestRectangleArea(heights);
		System.out.println(res);
	}
	
	//stack
	public int largestRectangleArea(int[] heights) {
		//stack中存递增高度
		Stack<Integer> s = new Stack<Integer>();
		int ma = 0;
		for(int i = 0; i < heights.length; i++) {
			//如果栈顶高度比当前高度高，则退栈
			//由目前栈顶高度向右计算可能的最大矩形面积，其实最终也把每个点所有可能的矩形面积都计算了一遍，但是由于优化计算，效率上好了很多
			while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
				int cur = s.pop();
				//计算矩形面积
				ma = Math.max(ma, heights[cur] * (s.isEmpty() ? i : (i - s.peek() - 1)));
			}
			//如果与栈顶是递增关系，则压栈
			s.push(i);
		}
		//由于最后stack中必定存在一个递增序列，因为在最后一次s.push(i)之后，没有计算，所以要将此递增序列计算完
		while(!s.isEmpty()) {
			int cur = s.pop();
			ma = Math.max(ma, heights[cur] * (s.isEmpty() ? heights.length : (heights.length - s.peek() - 1)));
		}
		return ma;
	}
	
	//优化的暴力
/*	public int largestRectangleArea(int[] heights) {
		int ma = 0;
		for(int i = 0; i < heights.length; i++) {
			//找局部峰值
			//如果不是目前峰值，则跳过
			if(i + 1 < heights.length && heights[i] < heights[i + 1]) {
				continue;
			}
			//如果是目前峰值，则向前计算矩形，会将目前峰值前面所有可能的矩形面积都计算一遍
			//所以虽然这个方法没有在每个点上向左右两边扩展计算所有可能的矩形面积，但是其实也变相计算了所有可能的矩形面积，只是换了种思维方式
			int mi = heights[i];
			for(int j = i; j >= 0; j--) {
				mi = Math.min(mi, heights[j]);
				int sum = mi * (i - j + 1);
				ma = Math.max(ma, sum);
			}
		}
		return ma;
	}*/
	
	//暴力
/*	public int largestRectangleArea(int[] heights) {
		int ma = 0;
		for(int i = 0; i < heights.length; i++) {
			//向左
			int left = i;
			for(; left >= 0 && heights[left] >= heights[i]; left--);
			//向右
			int right = i;
			for(; right < heights.length && heights[right] >= heights[i]; right++);
			int sum = (right - left - 1) * heights[i];
			if(sum > ma) {
				ma = sum;
			}
		}
		return ma;
	}*/

}
