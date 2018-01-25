package test;

public class IntegerTest {

	public static void main(String[] args) {
		//Integer范围-128~127
		//Integer与Integer比较
		Integer a_127 = 127;
		Integer b_127 = 127;
		Integer c_new_127 = new Integer(127);
		//编译a_127=127时，被翻译成Integer a_127=Integer.valueOf(127)
		//而在valueOf()的源码中，对于-128~127之间的数，会进行缓存，即Integer a_127=127时，会将127进行缓存，下次再写Integer b_127=127时，则会直接从缓存中取，就不会new了
		//所以a_127==b_127结果为true，而a_128==b_128结果为false
		System.out.println(a_127 == b_127);//true
		//因为c_new_127新建了一个对象，所以这里两个对象相比较，当然不一样
		System.out.println(a_127 == c_new_127);//注意：false
		Integer a_128 = 128;
		Integer b_128 = 128;
		System.out.println(a_128 == b_128);//注意：false
		Integer a_new_128 = new Integer(128);
		Integer b_new_128 = new Integer(128);
		//两个new出来的对象进行比较，一定为false
		System.out.println(a_new_128 == b_new_128);//注意：false
		System.out.println(a_128 == a_new_128);//注意：false
		//int与int比较
		int i_127 = 127;
		int n_127 = 127;
		System.out.println(i_127 == n_127);//true
		int i_128 = 128;
		int n_128 = 128;
		System.out.println(i_128 == n_128);//true
		//Integer与int比较
		//Integer与int比较时，Integer会自动拆箱为int
		System.out.println(a_127 == i_127);//true
		System.out.println(c_new_127 == i_127);//true
		System.out.println(a_128 == i_128);//注意：true
		System.out.println(a_new_128 == i_128);//注意：true
		
	}
}
