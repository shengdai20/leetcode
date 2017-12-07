package problem_52;


public class MainTest {

	public static void main(String[] args) {
		int n = 4;
		int res = new MainTest().solveNQueens(n);
		System.out.println(res);
	}
	
	public int solveNQueens(int n) {
		int[][] vis = new int[3][n + n];//vis标记哪一列，哪条主对角线，哪条副对角线已经放置值
		for(int i = 0; i < 3; i++) {//初始化标记数组
			for(int j = 0; j < n; j++) {
				vis[i][j] = 0;
			}
		}
		int res = 0;
		res = dfs(0, n, vis, res);
		return res;
	}
	
	public static int dfs(int row, int n, int[][] vis, int res) {
		if(row == n) {//如果已经放置完所有的列，则将当前解加入到list中
			res++;
			return res;
		}
		for(int col = 0; col < n; col++) {//对于每一行要放置的皇后，col表示当前行可以放置的列
			if(vis[0][col] == 0 && vis[1][col + row] == 0 && vis[2][row - col + n] == 0) {//关键判断：不同行，不同列，不同主对角线，不同副对角线
				vis[0][col] = 1;//列
				vis[1][col + row] = 1;//副对角线
				vis[2][row - col + n] = 1;//主对角线
				res = dfs(row + 1, n, vis, res);//递归
				vis[0][col] = 0;
				vis[1][col + row] = 0;
				vis[2][row - col + n] = 0;
			}
		}
		return res;
	}
}
