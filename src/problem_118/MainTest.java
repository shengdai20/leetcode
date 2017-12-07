package problem_118;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> list = new MainTest().generate(numRows);
		System.out.println(list);
		/*for(int i = 0; i < numRows; i++) {
			syso
		}*/
	}
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 1; i <= numRows; i++) {
			List<Integer> listIn = new ArrayList<Integer>();
			for(int j = 0; j < i; j++) {
				if(j == 0 || j == i - 1) {
					listIn.add(1);
				}
				else {
					listIn.add(list.get(i-2).get(j-1) + list.get(i-2).get(j));
				}
			}
			list.add(listIn);
		}
		return list;
	}
}
