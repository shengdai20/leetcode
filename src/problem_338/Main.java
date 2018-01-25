package problem_338;

public class Main {

	public static void main(String[] args) {
		int num = 5;
		int[] res = new Main().countBits(num);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}
	
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;
		for(int i = 1; i <= num; i++) {
			res[i] = (i & 1) + res[i >> 1];
		}
		return res;
	}
	
/*	public int[] countBits(int num) {
		int[] res = new int[num+1];
		res[0] = 0;
		for(int i = 1; i <= num; i++) {
			int tmp = i;
			res[i] = (tmp % 2) + res[tmp / 2];
		}
		return res;
	}*/
	
/*	public int[] countBits(int num) {
		int[] res = new int[num+1];
		for(int i = 0; i <= num; i++) {
			res[i] = bit(i);
		}
		return res;
	}
	public static int bit(int num) {
		int cnt = 0;
		while(num != 0) {
			cnt += num % 2;
			num /= 2;
		}
		return cnt;
	}*/

}
