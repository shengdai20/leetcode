package problem_131;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String s = "aab";
		List<ArrayList<String>> res = new Main().partition(s);
		System.out.println(res);
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmp = new ArrayList<String>();
		dfs(s, res, 0, tmp);
		return res;
	}
	private static void dfs(String s, ArrayList<ArrayList<String>> res, int start, ArrayList<String> tmp) {
		//如果找到一种划分情况，则将其接入结果集中
		if(start == s.length()) {
			res.add(new ArrayList<String>(tmp));
			return;
		}
		//寻找每一个可能的回文字符串
		for(int i = start; i < s.length(); i++) {
			//判断字符串的其中一个子串，如果是回文
			if(isPalindrome(s, start, i) == true) {
				//将这个回文子串加入结果中，记住substring(start,end)，是从start到end-1的字符串。
				tmp.add(s.substring(start, i + 1));
				//注意，下次划分的子串起始点应该是i+1，因为i已经在上一个子串中了
				dfs(s, res, i + 1, tmp);
				//回溯移除
				tmp.remove(tmp.size() - 1);
			}
		}
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
	}

}
