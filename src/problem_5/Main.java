package problem_5;

public class Main {

	public static void main(String[] args) {
		String s = "cbbd";
		String res = new Main().longestPalindrome(s);
		System.out.println(res);
	}

	//中心扩展
	public String longestPalindrome(String s) {
		int length = s.length();
		int start = 0, maxLength = 1;
		//aba的情况，以i为中心扩展
		for(int i = 0; i < length; i++) {
			int left = i - 1, right = i + 1;
			while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
				if(right - left + 1 > maxLength) {
					maxLength = right - left + 1;
					start = left;
				}
				left--;
				right++;
			}
		}
		//abba的情况，以i, i+1为中心扩展
		for(int i = 0; i < length; i++) {
			int left = i, right = i + 1;
			while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
				if(right - left + 1 > maxLength) {
					maxLength = right - left + 1;
					start = left;
				}
				left--;
				right++;
			}
		}
		return s.substring(start, start + maxLength);
	}
	
	//dp
	//dp公式：dp[i, j]=ture表示初始下标为i，终点下标为j的字符串是回文字符串，
	//dp[i, j]=true当且仅当dp[i+1, j-1]=true
/*	public String longestPalindrome(String s) {
		int length = s.length();
		boolean dp[][] = new boolean[length][length];
		int start = 0, maxLength = 1;
		//初始化回文长度是1-2
		for(int i = 0; i < length; i++) {
			dp[i][i] = true;
			if(i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}
		//计算回文长度是3-length
		for(int strLength = 3; strLength <= length; strLength++) {
			//计算所有长度为strLength的字符串是否是回文串
			for(int i = 0; i <= length - strLength; i++) {
				int j = i + strLength - 1;//子字符串终止位置
				if(dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					start = i;
					maxLength = strLength;
				}
			}
		}
		return s.substring(start, start + maxLength);
	}*/
	
	//暴力
/*	public String longestPalindrome(String s) {
		String res = "";
		//逐一检查每个子字符串
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				String tmp = s.substring(i, j + 1);
				if(isPalindrome(tmp) == true) {
					if(tmp.length() > res.length()) {
						res = tmp;
					}
				}
			}
		}
		if(res.length() == 0) {
			res = String.valueOf(s.charAt(0));
		}
		return res;
	}
	//判断子字符串是否是回文
	public static boolean isPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}*/
}
