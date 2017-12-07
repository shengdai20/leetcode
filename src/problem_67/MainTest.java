package problem_67;

public class MainTest {

	public static void main(String[] args) {
		String a = "110", b = "1";
		String res = new MainTest().addBinary(a, b);
		System.out.println(res);
	}
	
	public String addBinary(String a, String b) {
		char[] tmpa = a.toCharArray();
		char[] tmpb = b.toCharArray();
		int lengtha = tmpa.length;
		int lengthb = tmpb.length;
		int length = lengtha > lengthb ? lengtha : lengthb;
		char[] res = new char[length + 1];
		int flag = 0, num, t = 0, i, j;
		for(i = lengtha - 1, j = lengthb - 1;i >= 0 && j >= 0; i--, j--) {
			num = flag + (tmpa[i] - '0') + (tmpb[j] - '0');
			flag = num / 2;
			res[t++] = (char) ((num % 2) + '0');
		}
		while(i >= 0) {
			num = flag + (tmpa[i] - '0');
			flag = num / 2;
			res[t++] = (char) ((num % 2) + '0');
			i--;
		}
		while(j >= 0) {
			num = flag + (tmpb[j] - '0');
			flag = num / 2;
			res[t++] = (char) ((num % 2) + '0');
			j--;
		}
		while(flag != 0) {
			res[t++] = (char) ((flag % 2) + '0');
			flag = flag / 2;
		}
		for(int k = 0; k < t / 2; k++) {
			char tmp = res[k];
			res[k] = res[t - k - 1];
			res[t - k - 1] = tmp;
		}
		String s = "";
		for(char ch : res) {
			s += ch;
		}
		return s.trim();
	}
}
