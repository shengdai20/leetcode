package problem_49;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new Main().groupAnagrams(strs);
		System.out.println(res);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		return null;
	}
}
