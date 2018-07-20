package problem_66;

public class Main {

	public static void main(String[] args) {
		int[] digits = {0};
		int[] res = new Main().plusOne(digits);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public int[] plusOne(int[] digits) {
		int pos = digits.length - 1;
		int flag = (digits[pos] + 1) / 10;
		digits[pos] = (digits[pos] + 1) % 10;
		pos--;
		while(pos >= 0) {
			int num = digits[pos] + flag;
			digits[pos] = num % 10;
			flag = num / 10;
			pos--;
		}
		if(flag == 0) {
			return digits;
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		for(int i = 0; i < digits.length; i++) {
			res[i + 1] = digits[i];
		}
		return res;
	}
}
