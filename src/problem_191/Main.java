package problem_191;

public class Main {

	public static void main(String[] args) {
		int n = 11;
		int res = new Main().hammingWeight(n);
		System.out.println(res);
	}

	public int hammingWeight(int n) {
		int cnt = 0;
		for(int i = 0; i <= 31; i++) {
			//1<<i表示1左移i位，n&(1<<i)表示取n的第i位数值
			if((n & (1<<i)) != 0) {
				cnt++;
			}
		}
		return cnt;
	}
	
/*	public int hammingWeight(int n) {
		int cnt = 0;
		while(n != 0) {
			//1001
			//1001-1=1000	1001&1000=1000
			//1000-1=0111	1000&0111=0
			//1的个数是2，所以会计算两次
			n &= (n - 1);
			cnt++;
		}
		return cnt;
	}*/
	
/*	public int hammingWeight(int n) {
		int cnt = 0;
		String s = Integer.toBinaryString(n);//转为无符号二进制
		char[] binaries = s.toCharArray();
		for(char c : binaries) {
			if(c == '1') {
				cnt++;
			}
		}
		return cnt;
	}*/
	
/*	public int hammingWeight(int n) {
		int cnt = 0;
		while(n != 0) {
			cnt += n & 1;
			n >>= 1;
		}
		return cnt;
	}*/
}
