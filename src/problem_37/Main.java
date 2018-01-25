package problem_37;

public class Main {

	public static void main(String[] args) {
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
		};
		new Main().solveSudoku(board);
	}

	private static boolean flag = false;
	public void solveSudoku(char[][] board) {
		flag = false;//必须重置，因为flag这里作为全局变量存在，不重置的话，会导致下一个测试用例开始时flag的值就是true
		dfs(0, 0, board);
/*		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}*/
	}
	public static void dfs(int x, int y, char[][] board) {
		if(flag == true) {
			return;
		}
		if(x == 9 && y == 0) {//找到第十行第一个数时，表示数独结束
			flag = true;
			return;
		}
		if(y == 9) {//查找下一行第一个数
			dfs(x + 1, 0, board);
		}
		else if(board[x][y] != '.') {//查找下一个数
			dfs(x, y + 1, board);
		}
		else if(board[x][y] == '.') {
			for(int i = 1; i <= 9; i++) {
				if(check(x, y, (char)(i + '0'), board) == true) {
					board[x][y] = (char)(i + '0');
					dfs(x, y + 1, board);
					if(flag == true) {//一旦找到一个结果就返回，不再回溯，否则会导致最后的数组，回溯回最原始的状态。且记住：java中数组作为参数是传地址
						return;
					}
					board[x][y] = '.';
				}
			}
		}
	}
	public static boolean check(int x, int y, int value, char[][] board2) {
		for(int i = 0; i < 9; i++) {
			if(board2[x][i] == value) {//检验行
				return false;
			}
			if(board2[i][y] == value) {//检验列
				return false;
			}
		}
		x = x / 3 * 3;
		y = y / 3 * 3;
		for(int i = x; i < x + 3; i++) {//检验每个3*3方格
			for(int j = y; j < y + 3; j++) {
				if(board2[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
