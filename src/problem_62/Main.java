package problem_62;

public class Main {

	public static void main(String[] args) {
		int m = 51, n = 9;
		int res = new Main().uniquePaths(m, n);
		System.out.println(res);
	}

/*	public int uniquePaths(int m, int n) {
		double res = 1;
		for(int i = 1; i <= n - 1; i++) {
			res = res * (m + i - 1) / i;
		}
		return (int)res;
	}*/
	
	
	public int uniquePaths(int m, int n) {
		int dp[] = new int[n];
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		//每列刷新
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[j] += dp[j - 1];
			}
		}
		return dp[n - 1];
	}
	//dp
/*	public int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];
		//初始化
		//对于第一列和第一行，走的路径数应该初始化为1
		for(int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for(int i =0 ; i < n; i++) {
			dp[0][i] = 1;
		}
		//计算dp
		//对于dp[i][j]，每一个坐标[i,j]，都可以由其左侧和上侧走一步而来。类似于杨辉三角
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}*/
	
	//dfs
/*	public int uniquePaths(int m, int n) {
		int f[][] = {{0, 1}, {1, 0}};
		boolean vis[][] = new boolean[m][n];
		return dfs(m, n, 0, 0, 0, f, vis);
	}
	public static int dfs(int m, int n, int x, int y, int cnt, int f[][], boolean vis[][]) {
		if(x == m - 1 && y == n - 1) {
			System.out.println("answer:" + cnt);
			cnt++;
			return cnt;
		}
		for(int i = 0; i < 2; i++) {
			int cnt_x = x + f[i][0];
			int cnt_y = y + f[i][1];
			if(cnt_x < m && cnt_y < n && vis[cnt_x][cnt_y] == false) {
				vis[cnt_x][cnt_y] = true;
				cnt = dfs(m, n, cnt_x, cnt_y, cnt, f, vis);
				vis[cnt_x][cnt_y] = false;
			}
		}
		return cnt;
	}*/
}
