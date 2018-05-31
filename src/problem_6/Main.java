package problem_6;

public class Main {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String res = new Main().convert(s, numRows);
		System.out.println(res);
	}
	
	public String convert(String s, int numRows) {
		if(numRows <= 1) {
			return s;
		}
		StringBuilder res = new StringBuilder();
		int len = 2 * numRows - 2;
		for(int i = 0; i < numRows; i++) {
			//填充每一行的数据
			for(int j = i; j < s.length(); j += len) {
				//填充非斜位置的规律数值
				res.append(s.charAt(j));
				//处理非首行和非尾行的数据
				if(i != 0 && i != numRows - 1) {
					int tmp = j + len - 2 * i;
					if(tmp < s.length()) {
						res.append(s.charAt(tmp));
					}
				}
			}
		}
		return res.toString();
	}

}
