package problem_516;

public class Main {

	public static void main(String[] args) {
		String s = "bbbbabbbb";
		int res = new Main().longestPalindromeSubseq(s);
		System.out.println(res);
	}

	//记忆化搜索
/*	public int longestPalindromeSubseq(String s) {
		return dfs(s, 0, s.length() - 1, new int[s.length()][s.length()]);
	}
	public static int dfs(String s, int i, int j, int dp[][]) {
		if(dp[i][j] != 0) {//如果已经有值，则直接返回，代表记忆性
			return dp[i][j];
		}
		if(i > j) {
			return 0;
		}
		if(i == j) {
			return 1;
		}
		if(s.charAt(i) == s.charAt(j)) {
			dp[i][j] = dfs(s, i + 1, j - 1, dp) + 2;
		}
		else {
			dp[i][j] = Math.max(dfs(s, i + 1, j, dp), dfs(s, i, j -1, dp));
		}
		return dp[i][j];
	}*/
	
	//dp
	//dp公式：dp[i,j]=2表示下标i到j的字符串中，最长回文子序列长度是2
	//当s[i]=s[j]时，dp[i,j]=dp[i+1,j-1]+2
	//当s[i]!=s[j]时，dp[i,j]=max(dp[i+1,j],dp[i,j-1])
	public int longestPalindromeSubseq(String s) {
		int length = s.length();
		int dp[][] = new int[length][length];
		for(int i = length - 1; i >= 0; i--) {//从后向前dp计算，不知道为什么。。。
			dp[i][i] = 1;
			for(int j = i + 1; j < length; j++) {//逐一查看每个字符串中的字符序列是否有回文
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}
				else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println("dd:" + dp[1][0]);
		return dp[0][length - 1];
	}
}
