package test;

public class GCD {

	public static void main(String[] args) {
		int a = 17, b = 840;
		int x=1,y=0,t;
		if(a!=1&&b!=1){
		int b0=b,q;
		                 while(a>1){
		                    q=a/b0;
		                   t=b0;b0=a%b0;a=t;
	                     t=y;y=x-q*y;x=t;
		                 }
		                 if(x<0)x+=b;
	             }
		System.out.println(a + "," + x);
	
	 }
	
}
