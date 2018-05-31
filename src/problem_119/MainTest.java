package problem_119;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int rowIndex = 3;
		List<Integer> list = new MainTest().getRow(rowIndex);
		System.out.println(list);
	}
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		rowIndex++;
		for(int i = 0; i < rowIndex; i++) {
			//每遍历到一层，list中的数据就新加一个，此外别无添加，所以list的数据个数总是保持此次add后的恒定值
			//而这里的add其实就是将当前层的最后一个数置1
			list.add(1);
			for(int j = i - 1; j > 0; j--) {
				//从当前层的倒数第二个数开始往前到第二个数，进行遍历更新
				list.set(j, list.get(j - 1) + list.get(j));
			}
		}
		return list;
	}
	
/*	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		rowIndex++;
		//用单list，将所有行的所有数据都存在一个list中，没有分辨
		for(int i = 1; i <= rowIndex; i++) {
			for(int j = 0; j < i; j++) {
				if(j == 0 || j == i - 1) {
					list.add(1);
				}
				else {
					list.add(list.get(list.size()-i) + list.get(list.size()-i+1));
				}
			}
		}
		//从上面得到的list中，抽取最后一行的数据
		List<Integer> res = new ArrayList<Integer>();
		for(int i = list.size() - rowIndex; i < list.size(); i++) {
			res.add(list.get(i));
		}
		return res;
	}*/
}
