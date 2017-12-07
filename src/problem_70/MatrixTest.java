package problem_70;

public class MatrixTest {

	static int[][] matrix;
	
	public static void main(String[] args) {
		init(2);  
        matrix[0][0] = 1;  
        matrix[0][1] = 1;  
        matrix[1][0] = 1;  
        matrix[1][1] = 0;  
        int[][] temp = new int[matrix.length][matrix.length];  
        temp = pow(4);  
        for (int[] a : temp) {  
            for (int b : a) {  
                System.out.print(b + " ");  
            }  
            System.out.println();  
        }  
        System.out.println("斐波那契数列的fn值为：" + temp[0][1]);  
	}
	
	//初始化矩阵
	public static void init(int n) {  
        matrix = new int[n][n];  
    }  
  
	//矩阵相乘
    public static int[][] matrixMulti(int[][] m, int[][] n) {  
        int[][] temp = new int[matrix.length][matrix.length];  
        for (int k = 0; k < matrix.length; k++) {  
            for (int i = 0; i < matrix.length; i++) {  
                for (int j = 0; j < matrix.length; j++) {  
                    temp[k][i] += m[k][j] * n[j][i];  
                }  
            }  
        }  
        return temp;  
    }  
  
    //矩阵快速幂
    public static int[][] pow(int n) {  
        int[][] temp = new int[matrix.length][matrix.length];  
        if (n == 1) {  
            return matrix;  
        } else {  
            if (n % 2 != 0) {  //奇数
                temp = pow((n - 1) / 2);  
                temp = matrixMulti(temp, temp);  
                return matrixMulti(temp, matrix);  
            } else {  //偶数
                temp = pow(n / 2);  
                temp = matrixMulti(temp, temp);  
                return temp;  
            }  
        }  
    }  
}
