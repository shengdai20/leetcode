package problem_190;


public class Main {

	public static void main(String[] args) {
		int n = 10;
		int res = new Main().reverseBits(n);
		System.out.println(res);
	}

	public int reverseBits(int n) {
		int res = 0;
		for(int i = 0; i <= 31; i++) {
			//1010->tmp=0,n=101,res=00,
			int tmp = n & 1;//取最后一位
			n = n >> 1;//右移
			res = res<<1;//结果左移一位
			res = res | tmp;//将最后一位加到结果左移的那个位上去，也就是最低位上
		}
	//	System.out.println(Integer.toBinaryString(res));
		//在eclipse里会显示错误，因为res已经移位形成了32位的数，已经无法正常显示了
		//但是当转为二进制的时候是正常的
		return res;
	}
}
