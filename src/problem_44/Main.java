package problem_44;

public class Main {

	public static void main(String[] args) {
		String s = "aabb", p = "aab*";
		boolean res = new Main().isMatch(s, p);
		System.out.println(res);
	}
	
	//dp
	//dp[i, j]表示s前i个字符串和p前j个字符串是否匹配
	public boolean isMatch(String s, String p) {
		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		//初始化
		for(int i = 1; i <= p.length(); i++) {
			if(p.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 1];
			}
		}
		//计算dp
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= p.length(); j++) {
				if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
				else {
					dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1]; 
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	
/*	public boolean isMatch(String s, String p) {
		//sCurPos：s当前下标
		//pCurPos：p当前下标
		//pStarPos：p的最后一个*的下标
		//sMatch：s与p的*匹配的最后一个字符的下标
		int sCurPos = 0, pCurPos = 0, pStarPos = -1, sMatch = 0;
		while(sCurPos < s.length()) {
			System.out.println("sCurPos:" + sCurPos + ",pCurPos:" + pCurPos + ",pStarPos:" + pStarPos + ",sMatch:" + sMatch);
			//如果s当前字符==p当前字符或p当前字符是?，则s和p同时往后挪一位
			if(pCurPos < p.length() && (s.charAt(sCurPos) == p.charAt(pCurPos) || p.charAt(pCurPos) == '?')) {
				sCurPos++;
				pCurPos++;
			}
			//如果p当前字符是*，则记录p此时*的下标，并且记录s此时匹配的位置下标，p往后挪一位
			else if(pCurPos < p.length() && p.charAt(pCurPos) == '*') {
				pStarPos = pCurPos;
				sMatch = sCurPos;
				pCurPos++;
			}
			//如果前面p有过*，且前面的if都不满足，则将s往后挪到前面s匹配p的*的位置下标+1，并将p下标挪到*的下一个位置
			else if(pStarPos != -1) {
				pCurPos = pStarPos + 1;
				sMatch++;
				sCurPos = sMatch;
			}
			else {
				return false;
			}
		}
		//如果前面s和p已经匹配，但是p后面还有字符没和s匹配，则只能是*，才能正确匹配，否则无法匹配
		while(pCurPos < p.length() && p.charAt(pCurPos) == '*') {
			pCurPos++;
		}
		return pCurPos == p.length();
	}*/

}
