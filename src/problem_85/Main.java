package problem_85;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
	/*	char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};*/
	/*	char[][] matrix = {
		                   {'1', '1', '0', '0', '1'},
		                   {'0', '1', '0', '0', '1'},
		                   {'0', '0', '1', '1', '1'},
		                   {'0', '0', '1', '1', '1'},
		                   {'0', '0', '0', '0', '1'}
		                   };*/
		char[][] matrix = {{'1', '1'}};
		int res = new Main().maximalRectangle(matrix);
		System.out.println(res);
	}
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0) {
			return 0;
		}
		int h[] = new int[matrix[0].length];
		int left[] = new int[matrix[0].length], right[] = new int[matrix[0].length];
		//初始化right数组 为matrix[0].length
		for(int i = 0; i < matrix[0].length; i++) {
			right[i] = matrix[0].length;
		}
		int res = 0;
		for(int i = 0; i < matrix.length; i++) {
			int cur_left = 0, cur_right = matrix[0].length;
			//转换成直方图
			for(int j = 0; j < matrix[0].length; j++) {
				h[j] = (matrix[i][j] == '1') ? (h[j] + 1) : 0;
			}
			//计算左边1的下标
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == '1') {
					left[j] = Math.max(left[j], cur_left);
				}
				else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			//计算右边1的下标
			for(int j = matrix[0].length - 1; j >= 0; j--) {
				if(matrix[i][j] == '1') {
					right[j] = Math.min(right[j], cur_right);
				}
				else {
					right[j] = matrix[0].length;
					cur_right = j;
				}
			}
			//计算矩形面积
			for(int j = 0; j < matrix[0].length; j++) {
				res = Math.max(res, (right[j] - left[j]) * h[j]);
			}
		}
		return res;
	}
	
/*	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0) {
			return 0;
		}
		Stack<Integer> s = new Stack<Integer>();
		int h[] = new int[matrix[0].length];
		int res = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				//转换成直方图
				h[j] = (matrix[i][j] == '1') ? (h[j] + 1) : 0;
				//根据每个直方图，计算其最大矩形面积，利用84题的方法
				while(!s.isEmpty() && h[s.peek()] >= h[j]) {
					int cur = s.pop();
					res = Math.max(res, h[cur] * (s.isEmpty() ? j : (j - s.peek() - 1)));
				}
				s.push(j);
			}
			while(!s.isEmpty()) {
				int cur = s.pop();
				res = Math.max(res, h[cur] * (s.isEmpty() ? h.length : (h.length - s.peek() - 1)));
			}
		}
		return res;
	}*/

}
