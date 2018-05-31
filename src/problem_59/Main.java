package problem_59;

public class Main {

	public static void main(String[] args) {
		int n = 3;
		int[][] res = new Main().generateMatrix(n);
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[0].length; j++) {
				System.out.println(res[i][j]);
			}
		}
	}
	
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		if(n == 0) {
			return res;
		}
		int i = 0, j = 0, num = 1;
		res[i][j] = num;
		while(num < n * n) {
			//从左往后
			while(j < n - 1 && res[i][j + 1] == 0) {
				res[i][++j] = ++num;
			}
			//从上到下
			while(i < n - 1 && res[i + 1][j] == 0) {
				res[++i][j] = ++num;
			}
			//从右到左
			while(j > 0 && res[i][j - 1] == 0) {
				res[i][--j] = ++num;
			}
			//从下到上
			while(i > 0 && res[i - 1][j] == 0) {
				res[--i][j] = ++num;
			}
		}
		return res;
	}

}
