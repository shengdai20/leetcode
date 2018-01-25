package problem_17;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String digits = "";
		List<String> res = new Main().letterCombinations(digits);
		System.out.println(res);
	}
	
	private static String[] s = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};//1.将每个数字所对应的字符串存入数组。
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>(20);
		if(digits.length() == 0) {
			return res;
		}
		String listIn = "";
		dfs(digits, res, listIn, 0);
		return res;
	}
	public static void dfs(String digits, List<String> res, String listIn, int index) {
		if(listIn.length() == digits.length()) {
			res.add(new String(listIn));
		}
		if(index == digits.length()) {
			return;
		}
		int pos = digits.charAt(index) - '0';//2.将字符数字转为数字。
		int length = s[pos].length();
		for(int i = 0; i < length; i++) {
			listIn += s[pos].charAt(i);
			dfs(digits, res, listIn, index + 1);
			listIn = listIn.substring(0, listIn.length() - 1);//3.删除字符串最后一个字符。
		}
	}
}
