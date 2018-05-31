package problem_64;

public class Main {

	public static void main(String[] args) {
		int[][] gird = {{1,3,1},
		                {1,5,1},
		                {4,2,1}};
		int res = new Main().minPathSum(gird);
		System.out.println(res);
	}

	public int minPathSum(int[][] grid) {
		int[] dp = new int[grid[0].length];
		//初始化第一行
		dp[0] = grid[0][0];
		for(int j = 1; j < grid[0].length; j++) {
			dp[j] = grid[0][j] + dp[j - 1];
		}
		//从第一行第0列开始计算
		for(int i = 1; i < grid.length; i++) {
			//计算第0列
			dp[0] += grid[i][0];
			//从第1列开始
			for(int j = 1; j < grid[0].length; j++) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
			}
		}
		return dp[grid[0].length - 1];
	}
	
	//dp
/*	public int minPathSum(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length];
		//初始化第一列
		dp[0][0] = dp[0][0] = grid[0][0];
		for(int i = 1; i < grid.length; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		//初始化第一行
		for(int i = 1; i < grid[0].length; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		//计算dp
		for(int i = 1; i < grid.length; i++) {
			for(int j = 1; j < grid[0].length; j++) {
				//取从左边和从上边到达的最短路径+当前值
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[grid.length - 1][grid[0].length - 1];
	}*/
	
	//dfs
/*	public int minPathSum(int[][] grid) {
		boolean vis[][] = new boolean[grid.length][grid[0].length];
		int f[][] = {{1, 0}, {0, 1}};
		return dfs(grid, 0, 0, grid[0][0], Integer.MAX_VALUE, vis, f);
	}
	public static int dfs(int[][] grid, int x, int y, int sum, int res, boolean vis[][], int f[][]) {
		if(sum >= res) {
			return res;
		}
		if(x == grid.length - 1 && y == grid[0].length - 1) {
			if(sum < res) {
				res = sum;
			}
			return res;
		}
		for(int i = 0; i < 2; i++) {
			int cnt_x = x + f[i][0];
			int cnt_y = y + f[i][1];
			if(cnt_x < grid.length && cnt_y < grid[0].length && vis[cnt_x][cnt_y] == false) {
				vis[cnt_x][cnt_y] = true;
				res = dfs(grid, cnt_x, cnt_y, sum + grid[cnt_x][cnt_y], res, vis, f);
				vis[cnt_x][cnt_y] = false;
			}
		}
		return res;
	}*/
}
