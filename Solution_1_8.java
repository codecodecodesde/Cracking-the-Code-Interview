public class Solution_1_8{

	public void zeroMatrix_1(int[][] matrix){
		int M = matrix.length;
		int N = matrix[0].length;
		int extra = 1;
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(i == 0 && matrix[i][j] == 0 && extra == 1)
					extra = 0;

				if(matrix[i][j] == 0){
					if(matrix[i][0] != 0)
						matrix[i][0] = 0;
					if(matrix[0][j] != 0)
						matrix[0][j] = 0;
				}

			}
				
		}

		//check zero in the first col
		for(int i = 1; i < M; i++){
			if(matrix[i][0] == 0){
				for(int j = 1; j < N; j++)
					matrix[i][j] = 0;	
			}
		}

		//check zero in the first row
		for(int i = 1; i < N; i++){
			if(matrix[0][i] == 0){
				for(int j = 1; j < M; j++)
					matrix[j][i] = 0;	
			}
		}

		if(extra == 0){
			for(int j = 1; j < N; j++)
				matrix[0][j] = 0;	
		}

		if(matrix[0][0] == 0){
			for(int j = 1; j < M; j++)
				matrix[j][0] = 0;	
		}

	}

	

	public void printMatrix(int[][] matrix){
		for(int[] x : matrix){
			for(int y : x){
				System.out.print(y + " ");
			}
			System.out.println();
		}
		System.out.println();
	}



	public static void main(String[] args){
		Solution_1_8 s = new Solution_1_8();
		int[][] matrix = {{0,2,3,4},{3,1,9,6},{5,9,8,9},{1,6,8,0}};
		s.printMatrix(matrix);
		s.zeroMatrix_1(matrix);
		s.printMatrix(matrix);
	}
}