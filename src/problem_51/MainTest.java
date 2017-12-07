package problem_51;

import java.util.LinkedList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		int n = 4;
		List<List<String>> list = new MainTest().solveNQueens(n);
		int length = list.size();
		for(int i = 0; i < length; i++) {
			System.out.println(list.get(i));
		}
	}
	
	public List<List<String>> solveNQueens(int n) {
        int[] res = new int[n];//res的下标表示皇后放置在第几行，res的值表示皇后放置在第几列
        List<List<String>> list = new LinkedList<List<String>>();//list存储最终返回的所有解
        int[][] vis = new int[3][n + n];//vis标记哪一列，哪条主对角线，哪条副对角线已经放置值
        for(int i = 0; i < 3; i++) {//初始化标记数组
            for(int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        dfs(res, 0, n, list, vis);
        
        return list;
    }
    
    public static void dfs(int[] res, int row, int n, List<List<String>> list, int[][] vis) {
        if(row == n) {//如果已经放置完所有的列，则将当前解加入到list中
            List<String> listIn = new LinkedList<String>();//先将内置的List赋值
            for(int i = 0; i < res.length; i++) {
                String s = "";
                for(int j = 0; j < n; j++) {
                    if(j == res[i]) {
                        s += "Q";
                    }
                    else {
                        s += ".";
                    }
                }
                listIn.add(s);
            }
            list.add(listIn);//再将内置的list的值加入到要返回的list中
            return;
        }
        for(int col = 0; col < n; col++) {//对于每一行要放置的皇后，col表示当前行可以放置的列
            if(vis[0][col] == 0 && vis[1][col + row] == 0 && vis[2][row - col + n] == 0) {//关键判断：不同行，不同列，不同主对角线，不同副对角线
                vis[0][col] = 1;//列
                vis[1][col + row] = 1;//副对角线
                vis[2][row - col + n] = 1;//主对角线
                res[row] = col;//存储皇后应该放置的位置
                dfs(res, row + 1, n, list, vis);//递归
                vis[0][col] = 0;
                vis[1][col + row] = 0;
                vis[2][row - col + n] = 0;
            }
        }
    }
}
