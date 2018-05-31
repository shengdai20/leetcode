package problem_120;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> inList = new ArrayList<Integer>();
		inList.add(2);
		triangle.add(new ArrayList<Integer>(inList));
		inList.clear();
		inList.add(3);
		inList.add(4);
		triangle.add(new ArrayList<Integer>(inList));
		inList.clear();
		inList.add(6);
		inList.add(5);
		inList.add(7);
		triangle.add(new ArrayList<Integer>(inList));
		inList.clear();
		inList.add(4);
		inList.add(1);
		inList.add(8);
		inList.add(3);
		triangle.add(new ArrayList<Integer>(inList));
		int res = new Main().minimumTotal(triangle);
		System.out.println(res);
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
		int[] dp = new int[row];
		//初始化
		for(int i = 0; i < row; i++) {
			dp[i] = triangle.get(row - 1).get(i);
		}
		//逐行计算
		for(int i = row - 2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
	
/*	public int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
		int[][] dp = new int[row][row];
		//初始化最后一行
		for(int i = 0; i < row; i++) {
			dp[row - 1][i] = triangle.get(row - 1).get(i);
		}
		//从倒数第二行往上逐行进行计算
		for(int i = row - 2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0][0];
	}*/

}
