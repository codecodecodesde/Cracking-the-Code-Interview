public class Solution_1_7{

	public boolean rotateMatrix(int[][] matrix){
		if((matrix.length != matrix[0].length)|| (matrix.length == 0))
			return false;
		int n = matrix.length;
		for(int i = 0; i < n/2; i++){
			int start = i;//!!!
			int end = n - 1 - i;
			for(int j = start; j < end; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];//tips: m[row][col] = m[n-1-col][row];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}
		return true;
	}

	public static void main(String[] args){
		Solution_1_7 s = new Solution_1_7();
		int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
		if(s.rotateMatrix(matrix) != false){
			for(int[] i: matrix){
				for(int j : i){
					System.out.print(j + " ");
				}
				System.out.println();
			}
		}
	}

}