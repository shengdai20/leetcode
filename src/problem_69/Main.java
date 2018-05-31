package problem_69;

public class Main {

	public static void main(String[] args) {
		int x = 2;
		int res = new Main().mySqrt(x);
		System.out.println(res);
	}

	public int mySqrt(int x) {
		long tmp = x;
		while(tmp * tmp > x) {
			tmp = (tmp + x / tmp) / 2;
		}
		return (int)tmp;
	}
	
	//二分
/*	public int mySqrt(int x) {
		int left = 1, right = x;
		if(x == 0 || x == 1) {
			return x;
		}
		while(true) {
			int mid = left + (right - left) / 2;
			//如果mid * mid > x，则令right = mid - 1，因为值大了，而这里使用mid > x / mid的方式，是为了防止mid * mid过大，越了int的界限
			if(mid > x / mid) {
				right = mid - 1;
			}
			//如果mid * mid < x
			else {
				//如果(mid + 1) * (mid + 1) > x，则说明x的平方根是mid和mid+1中间的值，则取小者mid 
				if(mid + 1 > x / (mid + 1)) {
					return mid;
				}
				left = mid + 1;
			}
		}
	}*/
	
/*	public int mySqrt(int x) {
		if(x == 0 || x == 1) {
            return x;
        }
		int i = 0;
		for( ; i <= x / 2; i++) {
			long tmp = (long)i * (long)i;
			if(tmp > x) {
				return i - 1;
			}
			else if(tmp == x) {
				return i;
			}
		}
		return x / 2;
	}*/
	
/*	public int mySqrt(int x) {
		double res = Math.sqrt(x);
		return (int)Math.floor(res);
	}*/
}
