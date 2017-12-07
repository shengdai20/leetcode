package problem_70;

public class MainTest {

	public static void main(String[] args) {
		int n = 3;
		int res = new MainTest().climbStairs(n);
		System.out.println(res);
	}
	
	public int climbStairs(int n) {
		int[] fib = new int[1000];
		fib[0] = 1;
		fib[1] = 1;
		fib[2] = 2;
		for(int i = 3; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}
	
/*	public int climbStairs(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}*/
	
/*	public int climbStairs(int n) {
		int[] fib = new int[1000];
		for(int i = 0; i <= n; i++) {
			fib[i] = 0;
		}
		return fib(fib, n);
	}
	
	public int fib(int[] fib, int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 2;
		}
		if(fib[n] != 0) {
			return fib[n];
		}
		else {
			fib[n] = fib(fib, n - 1) + fib(fib, n - 2);
			return fib[n];
		}
	}*/
}
