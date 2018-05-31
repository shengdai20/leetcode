package problem_32;

public class Main {

	public static void main(String[] args) {
		String s = ")(()())";
		int res = new Main().longestValidParentheses(s);
		System.out.println(res);
	}
	
	//dp
	public int longestValidParentheses(String s) {
		int length = s.length();
		int[] dp = new int[length];
		int res = 0;
		for(int i = 0; i < length; i++) {
			dp[i] = 0;
			if(s.charAt(i) == ')' && (i - 1) >= 0) {
				if((i - 1) >= 0 && s.charAt(i - 1) == '(') {//如果前一个位置与当前括号')'匹配
					dp[i] = 2;//暂且只计算匹配的'('')'
					if(i - 2 >= 0) {//加上与')'匹配的'('前一个位置的dp匹配长度
						dp[i] += dp[i - 2];
					}
				}
				else {//如果前一个位置与当前括号'('不匹配
					if((i - 1 - dp[i - 1]) >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {//查看【前一个位置下标-匹配数】之后的字符与当前括号')'是否匹配
						dp[i] = dp[i - 1] + 2;//如果匹配，则在前一个位置匹配数的情况下+2，即加上刚与当前')'匹配的左右括号数量
						if(i - 2 - dp[i - 1] >= 0) {//加上与')'匹配的'('前一个位置的dp匹配长度
							dp[i] += dp[i - 2 - dp[i - 1]];
						}
					}
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
/*	public int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<Integer>();
		int res = 0, length = s.length();
		for(int i = 0; i < length; i++) {
			if(s.charAt(i) == '(') {
				st.push(i);
			}
			else {
				if(st.isEmpty()) {
					st.push(i);
				}
				else {
					if(s.charAt(st.peek())== '(') {
						st.pop();
						res = Math.max(res, (i - (st.isEmpty() ? -1 : st.peek())));
					}
					else {
						st.push(i);
					}
				}
			}
		}
		return res;
	}*/
	
/*	public int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<Integer>();//存'('下标
		int res = 0, lastIndex = -1, length = s.length();
		for(int i = 0; i < length; i++) {
			if(s.charAt(i) == '(') {//如果是'('，将下标压栈
				st.push(i);
			}
			else {//如果是')'，分情况讨论
				if(st.isEmpty()) {//如果为空，则出现')'没有'('匹配的情况，则当前子串结束，下一个子串的开始位置即是当前子串结束的下一个位置
					lastIndex = i;
				}
				else {//如果非空，可能出现两种情况：'()'或'(())'
					st.pop();
					if(st.isEmpty()) {//如果为空，则说明栈中没有'('需要匹配
						res = Math.max(res, i - lastIndex);
					}
					else {//如果非空，则当前栈中还有'('存在
						res = Math.max(res, i - st.peek());
					}
				}
			}
		}
		return res;
	}*/
	
/*	public int longestValidParentheses(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 2; j <= s.length(); j += 2) {
				int cnt = parentheses(s.substring(i, j));
				if(res < cnt) {
					res = cnt;
				}
			}
		}
		return res;
	}
	public static int parentheses(String s) {
		Stack<Character> st = new Stack<Character>();
		int cnt = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ')') {
				if(!st.isEmpty() && st.peek() == '(') {
					cnt++;
					st.pop();
				}
				else {
					return 0;
				}
			}
			else {
				st.push(c);
			}
		}
		if(!st.isEmpty()) {
			return 0;
		}
		return cnt * 2;
	}*/
}
