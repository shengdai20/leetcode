package problem_96;

public class Main {

	public static void main(String[] args) {
		int n = 3;
		int res = new Main().numTrees(n);
		System.out.println(res);
	}

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}
	
/*	public int numTrees(int n) {
		//卡特兰数
		//C(2n, n)/(n+1)
		long res = 1;
		for(int i = n + 1; i <= n * 2; i++) {
			res = res * i / (i - n);
		}
		return (int)(res / (n + 1));
	}*/
}
