package problem_125;

public class Main {

	public static void main(String[] args) {
	//	String s = "A man, a plan, a canal: Panama";
	//	String s = "race a car";
		String s = "0P";
		boolean res = new Main().isPalindrome(s);
		System.out.println(res);
	}
	
	public boolean isPalindrome(String s) {
		boolean res = true;
		int left = 0, right = s.length() - 1;
		while(left <= right) {
			//左边非数字和字母
			if(!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			//右边非数字和字母
			else if(!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			//如果都是数字和字母
			else {
				//判断是否回文相等
				if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					res = false;
					break;
				}
				left++;
				right--;
			}
		}
		return res;
	}
	
/*	public boolean isPalindrome(String s) {
		boolean res = true;
		int len = s.length(), k = 0;
		char[] tmp = new char[len];
		//去除空格和特殊字符，将所有字母转小写
		for(int i = 0; i < len; i++) {
			if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ) || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				tmp[k++] = s.charAt(i);
			}
			//大写转小写
			else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				tmp[k++] = (char)(s.charAt(i) + 32);
			}
		}
		//判断是否是回文
		int left = 0, right = k - 1;
		while(left <= right) {
			if(tmp[left] == tmp[right]) {
				left++;
				right--;
				continue;
			}
			else {
				res = false;
				break;
			}
		}
		return res;
	}*/
}
