package problem_132;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String s = "aab";
		int res = new Main().minCut(s);
		System.out.println(res);
	}
	
	public int minCut(String s) {
		//dp[i][j]表示在i到j之间的字符串是否是回文串
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
		}
		//mi[i]表示i到n-1之间的字符串最小需要分割的次数
		//从后往前计算
		int[] mi = new int[s.length() + 1];
		for(int i = s.length() - 1; i >= 0; i--) {
			mi[i] = Integer.MAX_VALUE;//初始化在i的后面分割一下
			for(int j = i; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1] == true)) {
					dp[i][j] = true;
					//因为i到j构成回文串，所以可以考虑在j后面分割，然后与在i后面分割进行比较
					mi[i] = Math.min(mi[i], 1 + mi[j + 1]);
				}
			}
		}
		return mi[0] - 1;
	}
	
/*	public int minCut(String s) {
		ArrayList<String> tmp = new ArrayList<String>();
		int res = Integer.MAX_VALUE;
		res = dfs(s, res, 0, tmp);
		return res;
	}
	private static int dfs(String s, int res, int start, ArrayList<String> tmp) {
		//如果找到一种划分情况，则将其接入结果集中
		if(start == s.length()) {
			if(tmp.size() - 1 < res) {
				res = tmp.size() - 1;
			}
			return res;
		}
		//寻找每一个可能的回文字符串
		for(int i = start; i < s.length(); i++) {
			//判断字符串的其中一个子串，如果是回文
			if(isPalindrome(s, start, i) == true) {
				//将这个回文子串加入结果中，记住substring(start,end)，是从start到end-1的字符串。
				tmp.add(s.substring(start, i + 1));
				//注意，下次划分的子串起始点应该是i+1，因为i已经在上一个子串中了
				res = dfs(s, res, i + 1, tmp);
				//回溯移除
				tmp.remove(tmp.size() - 1);
			}
		}
		return res;
	}
	//判断回文
	private static boolean isPalindrome(String s, int start, int end) {
		while(start <= end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}*/
}
