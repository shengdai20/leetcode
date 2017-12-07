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
			list.add(1);
			for(int j = i - 1; j > 0; j--) {
				list.set(j, list.get(j - 1) + list.get(j));
			}
		}
		return list;
	}
	
/*	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		rowIndex++;
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
		List<Integer> res = new ArrayList<Integer>();
		for(int i = list.size() - rowIndex; i < list.size(); i++) {
			res.add(list.get(i));
		}
		return res;
	}*/
}
