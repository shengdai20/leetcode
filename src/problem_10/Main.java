package problem_10;

public class Main {

	public static void main(String[] args) {
		String s = "aab", p = "c*a*b";
		boolean res = new Main().isMatch(s, p);
		System.out.println(res);
	}
	
	public boolean isMatch(String s, String p) {
		if(p.isEmpty()) {
			return s.isEmpty();
		}
		
		return true;
	}

}
