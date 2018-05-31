package problem_91;

public class Main {

	public static void main(String[] args) {
		String s = "12";
		int res = new Main().numDecodings(s);
		System.out.println(res);
	}

	//dp
	//dp[i]表示从0到i的字符串的解码方式的种类
	public int numDecodings(String s) {
		if(s.length() == 0) {
			return 0;
		}
		int dp[] = new int[s.length() + 1];
		//初始化0
		dp[0] = 1;
		//计算dp
		for(int i = 1; i < dp.length; i++) {
			dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
			if(i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}
}
