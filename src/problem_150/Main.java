package problem_150;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
	//	String[] tokens = {"2", "1", "+", "3", "*"};
		String[] tokens = {"4", "13", "5", "/", "+"};
		int res = new Main().evalRPN(tokens);
		System.out.println(res);
	}

/*	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < tokens.length; i++) {
			//如果是数值
			if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
				s.push(Integer.parseInt(tokens[i]));
			}
			//如果是操作符
			else {
				int b = s.pop();
				int a = s.pop();
				int c = compute(a, b, tokens[i]);
				s.push(c);
			}
		}
		return s.pop();
	}*/
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < tokens.length; i++) {
			//捕捉异常，来辨别是数值还是操作符
			try {
				s.push(Integer.parseInt(tokens[i]));
			}
			catch(Exception e) {
				int b = s.pop();
				int a = s.pop();
				int c = compute(a, b, tokens[i]);
				s.push(c);
			}
		}
		return s.pop();
	}
	private static int compute(int a, int b, String s) {
		if(s.equals("+")) {
			return a + b;
		}
		else if(s.equals("-")) {
			return a - b;
		}
		else if(s.equals("*")) {
			return a * b;
		}
		else {
			return a / b;
		}
	}
}
