package test;

public class Test<T> {

	private String msg;
	private T data;
	
	public Test(String msg) {
		this.msg = msg;
	}
	
	public Test(T data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		Test test1 = new Test("aaa");
		String s = new String("jjj");
		Test test2 = new Test(s);
		System.out.println(test1.data + "..." + test1.msg);
		System.out.println(test2.data + "..." + test2.msg);
	}

}
