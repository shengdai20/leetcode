package problem_174;

public class Main {

	public static void main(String[] args) {
		int[][] dungeon = {
				{-2, -3, 3},
				{-5, -10, 1},
				{10, 30, -5}
		};
		/*int[][] dungeon = {
				{1, -3, 3},
				{0, -2, 0},
				{-3, -3, -3}
		};*/
	//	int[][] dungeon = {{100}};
		int res = new Main().calculatedMinimumHP(dungeon);
		System.out.println(res);
	}

	//dp
	public int calculatedMinimumHP(int[][] dungeon) {
		int dp[][] = new int[dungeon.length][dungeon[0].length];
		//初始化最后一列
		//由于走到每个格子时，都要保持至少一个血量，所以应该用到max(1, ...)
		dp[dungeon.length - 1][dungeon[0].length - 1] = Math.max(1, 1 - dungeon[dungeon.length - 1][dungeon[0].length - 1]);
		for(int i = dungeon.length - 2; i >= 0; i--) {
			dp[i][dungeon[0].length - 1] = Math.max(1, dp[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1]);
		}
		//初始化最后一行
		for(int i = dungeon[0].length - 2; i >= 0; i--) {
			dp[dungeon.length - 1][i] = Math.max(1, dp[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i]);
		}
		//计算dp
		for(int i = dungeon.length - 2; i >= 0; i--) {
			for(int j = dungeon[0].length - 2; j >= 0; j--) {
				//从下边和右边中取出最小者，然后减去当前值
				dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
			}
		}
		return dp[0][0];
	}
	
	//dfs
/*	public int calculatedMinimumHP(int[][] dungeon) {
		boolean vis[][] = new boolean[dungeon.length][dungeon[0].length];
		int f[][] = {{1, 0}, {0, 1}};
		vis[0][0] = false;
		return dfs(dungeon, 0, 0, dungeon[0][0], Integer.MAX_VALUE, dungeon[0][0], vis, f);
	}
	public int dfs(int[][] dungeon, int x, int y, int sum, int res, int blood, boolean vis[][], int f[][]) {
		if(x == dungeon.length - 1 && y == dungeon[0].length - 1) {
			//递归结束点是每条线路的过程中的最大失血量
			if(blood < 0) {//如果失血量为负数，则是绝对值+1
				if(Math.abs(blood) < res) {
					res = Math.abs(blood) + 1;
 				}
			}
			else {//如果失血量>=0，则是1，因为当失血量为0时，也会死亡
				res = 1;
			}
			return res;
		}
		for(int i = 0; i < 2; i++) {
			int cnt_x = x + f[i][0];
			int cnt_y = y + f[i][1];
			if(cnt_x < dungeon.length && cnt_y < dungeon[0].length && vis[cnt_x][cnt_y] == false) {
				vis[cnt_x][cnt_y] = true;
				res = dfs(dungeon, cnt_x, cnt_y, sum + dungeon[cnt_x][cnt_y], res, blood < (sum + dungeon[cnt_x][cnt_y]) ? blood : (sum + dungeon[cnt_x][cnt_y]), vis, f);
				vis[cnt_x][cnt_y] = false;
			}
		}
		return res;
	}*/
}
