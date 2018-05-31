package problem_14;

public class Main {

	public static void main(String[] args) {
		String[] strs = {"123d", "123", "12"};
		String res = new Main().longestCommonPrefix(strs);
		System.out.println(res);
	}
	
	public String longestCommonPrefix(String[] strs) {
		int i = 0;
		String res = "";
		if(strs.length == 0 || strs[0].length() == 0) {
			return res;
		}
		while(true) {
			char ch = strs[0].charAt(i);
			boolean flag = false;
			for(int j = 1; j < strs.length; j++) {
				//如果遍历到某个字符串的结尾字符，则到此结束
				if(i == strs[j].length()) {
					flag = true;
					break;
				}
				//如果遍历到字符不相等，则到此结束
				if(strs[j].charAt(i) != ch) {
					flag = true;
					break;
				}
			}
			if(flag == true) {
				break;
			}
			res += String.valueOf(ch);
			i++;
		}
		return res;
	}

}
