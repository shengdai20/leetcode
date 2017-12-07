package problem_22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		int n = 3;
		List<String> ans = new MainTest().generateParenthesis(n);
		System.out.println(ans);
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> s = new ArrayList<String>();
		String tmp = "";
		dfs(s, tmp, n, n);
		return s;
	}
	
	public static void dfs(List<String> s, String tmp, int left, int right) {
		//递归结束条件
		if(left == 0 && right == 0) {
			s.add(tmp);
		}
		//回溯也会在此发生
		if(left > 0) {
			dfs(s, tmp + '(', left - 1, right);
		}
		if(right > 0 && left < right) {//别忘了加入left<right条件，这个条件表示当前字符串中已有的(的数量要比)小，才能得到符合括号匹配条件的字符串结果
			dfs(s, tmp + ')', left, right - 1);
		}
	}
	
/*	public List<String> generateParenthesis(int n) {
		List<String> s = new ArrayList<String>();
		String tmp = "";
		dfs(s, tmp, n);
		return s;
	}
	
	public static void dfs(List<String> s, String tmp, int n) {
		System.out.println(tmp);
		//递归结束点
		if(tmp.length() == n * 2) {//验证是否满足括号匹配
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;
			for(int i = 0; i < n * 2; i++) {
				if(tmp.charAt(i) == '(') {
					stack.push(tmp.charAt(i));
				}
				else {
					if(stack.isEmpty() || stack.pop() != '(') {
						flag = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) {
				flag = false;
			}
			//如果满足，将string放入list结果集中
			if(flag == true) {
				s.add(tmp);
			}
			return;
		}
		tmp = tmp + '(';
		dfs(s, tmp, n);
		tmp = tmp.substring(0, tmp.length() - 1);//回溯一定要记得将值置回原位，这里采用删除string最后一位置原的办法
		tmp = tmp + ')';
		dfs(s, tmp, n);
	}*/
}
