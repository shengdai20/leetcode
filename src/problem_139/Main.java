package problem_139;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean res = new Main().wordBreak(s, wordDict);
		System.out.println(res);
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		
		return true;
	}
}
