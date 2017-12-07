package problem_20;

import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		String s = "()[][(]";
		boolean res = new MainTest().isValid(s);
		System.out.println(res);
	}
	
	public boolean isValid(String s) {
		char[] str = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length; i++) {
			if(str[i] == '(' || str[i] == '[' || str[i] == '{') {
				stack.push(str[i]);
			}
			else if(str[i] == ')') {
				if(!stack.isEmpty() && stack.pop() == '(') {
					continue;
				}
				else {
					return false;
				}
			}
			else if(str[i] == ']') {
				if(!stack.isEmpty() && stack.pop() == '[') {
					continue;
				}
				else {
					return false;
				}
			}
			else if(str[i] == '}') {
				if(!stack.isEmpty() && stack.pop() == '{') {
					continue;
				}
				else {
					return false;
				}
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
