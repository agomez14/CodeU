//In some applications of 2-dimensional arrays or matrices, the matrix may be very large, 
//but the data may be very sparse (i.e., most of the values are zero).  
//In such cases it may be far more efficient to input or output only the non-zero values.  
//Write a function that accepts an integer matrix as input and generates 
//a line of output for each non-zero value in the matrix.  Each line should have the following format:
//     [row_number, column_number]: value
//For example, for the following matrix:
//   | 0 0 0 0 |
//   | 0 6 0 0 |
//   | 8 0 0 4 |
//the expected output would be:
//   [1, 1]: 6
//   [2, 0]: 8
//   [2, 3]: 4
//Also write a main routine that creates several test matrices and calls your function to output them.
public class SparseMatrixOutput {
	public static void MatrixOutput(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int x=0; x<matrix[i].length; x++){
				if(matrix[i][x]!=0){
					System.out.println("["+Integer.toString(i)+", "+Integer.toString(x)+"]: "+Integer.toString(matrix[i][x]));
				}
			}
		}
	}
	public static void main(String[] args) {
		int[][] test1 = {{0,0,0,0},
						 {0,6,0,0},
						 {8,0,0,4}};
		System.out.println("TEST1: ");
		MatrixOutput(test1);
		
		int[][] test2 = {{1,0,0,10},
				 		 {0,0,5,0},
				 		 {0,0,0,78},
				 		 {0,67,9,4}};
		System.out.println("TEST2: ");
		MatrixOutput(test2);
		

	}

}
