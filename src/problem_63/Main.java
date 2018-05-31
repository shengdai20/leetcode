package problem_63;

public class Main {

	public static void main(String[] args) {
/*		int obstacleGrid[][] = {
		                        {0,0,0},
		                        {0,1,0},
		                        {0,0,0}
		                        };*/
	//	int obstacleGrid[][] = {{1, 0}};
		int obstacleGrid[][] = {
				{0, 0}, 
				{1, 1}, 
				{0, 0}};
		int res = new Main().uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
			return 0;
		}
		int[] dp = new int[obstacleGrid[0].length];
		dp[0] = 1;
		//从0开始遍历，否则会漏掉第一列，因为其实第一列并没有初始化
		for(int i = 0; i < obstacleGrid.length; i++) {
			for(int j = 0; j < obstacleGrid[0].length; j++) {
				//遇到障碍则赋0
				if(obstacleGrid[i][j] == 1) {
					dp[j] = 0;
				}
				//由于j是从0开始，所以只考虑>0的情况
				else if(j > 0){
					dp[j] += dp[j - 1];
				}
			}
		}
		return dp[obstacleGrid[0].length - 1];
	}
	
	//dp
/*	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		//如果起始位置或结束位置是1，则直接不通
		if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
			return 0;
		}
		int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
		//初始化第一列
		for(int i = 0; i < obstacleGrid.length; i++) {
			if(obstacleGrid[i][0] == 0) {
				dp[i][0] = 1;
			}
			else {//第一列，一旦碰到一个障碍1，则第一列障碍下面的所有都是障碍，不通
				for(; i < obstacleGrid.length; i++) {
					dp[i][0] = 0;
				}
				break;
			}
		}
		//初始化第一行
		for(int i = 0; i < obstacleGrid[0].length; i++) {
			if(obstacleGrid[0][i] == 0) {
				dp[0][i] = 1;
			}
			else {//第一行，一旦碰到一个障碍1，则第一行障碍后面的所有都是障碍，不通
				for(; i < obstacleGrid[0].length; i++) {
					dp[0][i] = 0;
				}
				break;
			}
		}
		//计算dp
		for(int i = 1; i < obstacleGrid.length; i++) {
			for(int j = 1; j < obstacleGrid[0].length; j++) {
				if(obstacleGrid[i][j] == 1) {//如果当前格是障碍，则不可通
					dp[i][j] = 0;
				}
				else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}*/
	
	//dfs
/*	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		boolean vis[][] = new boolean[obstacleGrid.length][obstacleGrid[0].length];
		int f[][] = {{1, 0}, {0, 1}};
		//如果起始格子就是障碍，则表示不能正常到达目的地
		if(obstacleGrid[0][0] == 1) {
			return 0;
		}
		return dfs(obstacleGrid, 0, 0, 0, f, vis);
	}
	public static int dfs(int[][] obstacleGrid, int x, int y, int cnt, int f[][], boolean vis[][]) {
		if(x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1 && obstacleGrid[x][y] == 0) {
			cnt++;
			return cnt;
		}
		for(int i = 0; i < 2; i++) {
			int cnt_x = x + f[i][0];
			int cnt_y = y + f[i][1];
			if(cnt_x < obstacleGrid.length && cnt_y < obstacleGrid[0].length && vis[cnt_x][cnt_y] == false && obstacleGrid[cnt_x][cnt_y] == 0) {
				vis[cnt_x][cnt_y] = true;
				cnt = dfs(obstacleGrid, cnt_x, cnt_y, cnt, f, vis);
				vis[cnt_x][cnt_y] = false;
			} 
		}
		return cnt;
	}*/

}
