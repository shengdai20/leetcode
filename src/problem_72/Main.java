package problem_72;

public class Main {

	public static void main(String[] args) {
		String word1 = "abcd", word2 = "ab";
		int res = new Main().minDistance(word1, word2);
		System.out.println(res);
	}
	
	//dp
	//dp公式：dp[i][j]表示第一个字符串前i个字符到第二个字符串前j个字符的编辑距离长度
	//当word1[i]==word2[j]时，dp[i][j]=dp[i-1][j-1]
	//否则,dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
	public int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		int dp[][] = new int[len1+1][len2+1];
		//初始化
		for(int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for(int i = 0; i <= len2; i++) {
			dp[0][i] = i;
		}
		for(int i = 1; i <= len1; i++) {//下标从1开始
			for(int j = 1; j <= len2; j++) {
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
				else {
					int min = Integer.MAX_VALUE;
					if(min > dp[i - 1][j - 1]) {
						min = dp[i - 1][j - 1];
					}
					if(min > dp[i][j - 1]) {
						min = dp[i][j - 1];
					}
					if(min > dp[i - 1][j]) {
						min = dp[i - 1][j];
					}
					dp[i][j] = min + 1;
				}
			}
		}
		return dp[len1][len2];
	}
}
