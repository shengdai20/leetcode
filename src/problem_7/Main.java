package problem_7;

public class Main {

	public static void main(String[] args) {
		int x = -120;
		int res = new Main().reverse(x);
		System.out.println(res);
	}
	
	public int reverse(int x) {
		int res = 0;
		while(x != 0) {
			int tmp = x % 10;
			if((res < Integer.MIN_VALUE / 10) || (res > Integer.MAX_VALUE / 10)) {//判断溢出
				return 0;
			}
			res = res * 10 + tmp;
			x /= 10;
		}
		return res;
	}
	
/*	public int reverse(int x) {
		boolean mark = false;
		if(x < 0) {
			mark = true;
			x = -x;
		}
		//转为字符串做
		String s = Integer.toString(x);
		char[] rs = s.toCharArray();
		int length = rs.length - 1;
		//字符串反转
		for(int i = 0; i < length; i++, length--) {
			rs[i] ^= rs[length];
			rs[length] ^= rs[i];
			rs[i] ^= rs[length];
		}
		s = String.copyValueOf(rs);
		//将字符串转为数值
		if(mark == true) {//负数
			if(s.length() < 10) {
				return -Integer.parseInt(s);
			}
			else if(s.length() > 10) {
				return 0;
			}
			else {
				//x.compareTo(y)，如果x<y，返回数值<0；如果x>y，返回数值>0
				if("2147483648".compareTo(s) < 0) {
					return 0;
				}
				else {
					return -Integer.parseInt(s);
				}
			}
			
		}
		else {//正数
			if(s.length() < 10) {
				return Integer.parseInt(s);
			}
			else if(s.length() > 10) {
				return 0;
			}
			else {System.out.println(s);
				if("2147483647".compareTo(s) < 0) {
					return 0;
				}
				else {
					return Integer.parseInt(s);
				}
			}
		}
	}*/

}
