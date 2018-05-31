package problem_58;

public class Main {

	public static void main(String[] args) {
		String s = "Hello World ";
		int res = new Main().lengthOfLastWord(s);
		System.out.println(res);
	}
	
	public int lengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
	}
	
/*	public int lengthOfLastWord(String s) {
		int len = s.length(), cnt = 0;
		boolean flag = false;
		for(int i = len - 1; i >= 0; i--) {
			if(s.charAt(i) == ' ') {
				if(flag == true) {
					break;
				}
			}
			else {
				//直接计数最后一个单词的字符个数
				cnt++;
				flag = true;
			}
		}
		return cnt;
	}*/

}
