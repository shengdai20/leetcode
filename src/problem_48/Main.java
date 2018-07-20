package problem_48;

public class Main {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		new Main().rotate(matrix);
	}
	
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		//得到转置矩阵
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		//沿y轴中线翻转
		for(int i = 0; i < n; i++) {
			for(int  j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}
	
/*	public void rotate(int[][] matrix) {
		int n = matrix.length;
		//沿对角线翻转
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][n - i - 1];
				matrix[n - j - 1][n - i - 1] = tmp;
			}
		}
		//沿x轴中线翻转
		for(int i = 0; i < n / 2; i++) {
			for(int j = 0; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = tmp;
			}
		}
	}*/
	
/*	public void rotate(int[][] matrix) {
		int n = matrix.length;
		//逐行
		for(int i = 0; i < n / 2; i++) {
			//每行中需要旋转的数值
			for(int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = tmp;
			}
		}
	}*/
 	
/*	public void rotate(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix.length];
		int k = matrix.length - 1;
		//逐行换到逐列
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				res[j][k] = matrix[i][j];
			}
			k--;
		}
		//将数值复制回去
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[i][j] = res[i][j];
			}
		}
	}*/

}
