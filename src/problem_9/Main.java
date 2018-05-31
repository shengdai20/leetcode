package problem_9;

public class Main {

	public static void main(String[] args) {
		int x = 1;
		boolean res = new Main().isPalindrome(x);
		System.out.println(res);
	}

/*	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		int len = s.length();
		for(int i = 0; i < len / 2; i++) {
			if(s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}*/
	
    public boolean isPalindrome(int x) {
		if(x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int res = 0;
		while(x > res) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return (x == res || res / 10 == x);
    }
}
