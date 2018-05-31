package problem_343;

public class Main {

	public static void main(String[] args) {
		int n = 4;
		int res = new Main().integerBreak(n);
		System.out.println(res);
	}

	//dp
	//dp[i]表示给定i分解后能得到的最大乘积值
/*	public int integerBreak(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= n; i++) {
			for(int j = 1; j <= i / 2; j++) {
				//max里面要加上dp[i]，因为里层for循环会不断更新dp[i]，否则dp[i]得到就是最后一次的计算结果，而取不到最大值
				//后面Math.max(j, dp[j]) * Math.max(i - j, dp[i - j])，因为j+(i-j)=i，所以计算j和i-j的乘积，是正常的，只不过这里可以用到先前已经算过的dp[j]和dp[i-j]，因为dp[j]的结果就是j的最大分解结果，那么也可以是i的分解结果
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
			}
		}
		return dp[n];
	}*/
	
	//数学
	public int integerBreak(int n) {
		if(n == 2) {
			return 1;
		}
		else if(n == 3) {
			return 2;
		}
		else if(n == 1) {
			return 1;
		}
		else if(n % 3 == 0) {
			return (int)Math.pow(3, n / 3);
		}
		else if(n % 3 == 1) {
			return 2 * 2 * (int)Math.pow(3, (n - 4) / 3);
		}
		else {
			return 2 * (int)Math.pow(3, (n - 2) / 3);
		}
	}
}
