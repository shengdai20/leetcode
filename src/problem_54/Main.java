package problem_54;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
	//	int[][] matrix = {{3},{2}};
		List<Integer> res = new Main().spiralOrder(matrix);
		System.out.println(res);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix.length == 0) {
			return res;
		}
		int num = 1, m = matrix.length, n = matrix[0].length, i = 0, j = 0;
		res.add(matrix[i][j]);
		boolean vis[][] = new boolean[matrix.length][matrix[0].length];
		vis[i][j] = true;
		while(num < m * n) {
			//从左到右
			while(j < n - 1 && vis[i][j + 1] == false) {
				res.add(matrix[i][++j]);
				vis[i][j] = true;
				num++;
			}
			//从上到下
			while(i < m - 1 && vis[i + 1][j] == false) {
				res.add(matrix[++i][j]);
				vis[i][j] = true;
				num++;
			}
			//从右到左
			while(j > 0 && vis[i][j - 1] == false) {
				res.add(matrix[i][--j]);
				vis[i][j] = true;
				num++;
			}
			//从下到上
			while(i > 0 && vis[i - 1][j] == false) {
				res.add(matrix[--i][j]);
				vis[i][j] = true;
				num++;
			}
		}
		return res;
	}
}
