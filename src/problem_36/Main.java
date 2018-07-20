package problem_36;

import java.util.HashMap;
import java.util.HashSet;

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
		boolean res = new Main().isValidSudoku(board);
		System.out.println(res);
	}

	public boolean isValidSudoku(char[][] board) {
		//第一个[]是本行，第二个[]是本行中是否存在num
		boolean[][] row = new boolean[9][9];
		//第二个[]是本列 ，第二个[]是本列中是否存在num
		boolean[][] col = new boolean[9][9];
		boolean[][] cell = new boolean[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					int num = board[i][j] - '1';
					//行，列，小三角是否有重复
					if(row[i][num] || col[num][j] || cell[3 * (i / 3) + j / 3][num]) {
						return false;
					}
					//标记
					row[i][num] = true;
					col[num][j] = true;
					cell[3 * (i / 3) + j / 3][num] = true;
				}
			}
		}
		return true;
	}
	
/*	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(check(i, j, board) == false) {
					return false;
				}
			}
		}
		return true;
	}
	private boolean check(int x, int y, char[][] board) {
		if(board[x][y] != '.') {
			for(int i = 0; i < 9; i++) {
				//判断行
				if(i != y && board[x][i] == board[x][y]) {
					return false;
				}
				//判断列
				if(i != x && board[i][y] == board[x][y]) {
					return false;
				}
			}
		}
		x = x / 3 * 3;
		y = y / 3 * 3;
		HashSet<Character> set = new HashSet<Character>();
		//判断3*3的框
		for(int i = x; i < x + 3; i++) {
			for(int j = y; j < y + 3; j++) {
				if(board[i][j] != '.') {
					if(set.contains(board[i][j])) {
						return false;
					}
					else {
						set.add(board[i][j]);
					}
				}
			}
		}
		return true;
	}*/
}
