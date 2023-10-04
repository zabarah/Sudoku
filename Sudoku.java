public class Sudoku{



        //print matrix
	static void print(int[][] matrix)
        {
                for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++)
                                System.out.print(matrix[i][j] + " ");
                        System.out.print("\n");
                }
        }


	//check if a value (num) is in the 3*3 box of the of the field. If it exists it returns true else it returns false 
	static boolean in_box(int[][] matrix, int row, int col, int num){
		int left_border = (col/3) *3;
		int upper_border = (row/3) *3;
		//System.out.print(left_border);
		//System.out.print(upper_border);
		for(int check_col=left_border;check_col<(left_border+3); check_col++){
			for(int check_row=upper_border;check_row<(upper_border+3);check_row++){
				if(num == matrix[check_row][check_col]){
				//System.out.print("I found similar ");
					return true;
				}

			}
		}
		return false;
	
	}
	//check if a value (num) is in a row of the field. If it exists it returns true else it returns false 
	static boolean in_row(int[][] matrix, int row, int num){
		for(int check_col=0;check_col<9; check_col++){
				if(num == matrix[row][check_col]){
				return true;
				}
			}
		return false;
	
	}
	//check if a value (num) is in a row of the field. If it exists it returns true else it returns false 
	static boolean in_col(int[][] matrix, int col, int num){
		for(int check_row=0;check_row<9; check_row++){
				if(num == matrix[check_row][col]){
				return true;
				}
			}
		return false;
	
	}
	//it will try to fill in the field by trying numbers 1-9 and checking if they exists in box or in the row or the column. 
	//If it find a  none existing number it will fill it in the matrix argument and return. If it can not find a number it will return False. 
	static boolean try_to_fill(int[][] matrix, int row, int col){
		//checking all the combinations in a specific field
		for(int i=1;i<10;i++){
			if(!in_box(matrix, row,col,i) && !in_row(matrix,row,i) && !in_col(matrix,col,i)){
				matrix[row][col] = i;
			        if(solve_it(matrix,row,col+1)) {return true;}

				
			}
			//if we put a number that doesn't work we back track
			matrix[row][col] = 0;
		}
		return false;
	}

	static boolean solve_it(int[][] matrix, int row, int col){
		//check if we reach the end of the row. if so we need to move to the next row		
		if(col ==9 ){
			row++;
			col =0;
		}
		// if we moved beyond the last row then we return that it was successfull.
		if(row==9){ return true;}
	
	// if it is already filled we move to the next box

		if (matrix[row][col] >0){
			return solve_it(matrix, row, col+1);
		}
				// we try to fill an empty box and if not we return a failed code
		if(!try_to_fill(matrix, row,col)){
			return false;
		}
                return true;
		}

	public static void main(String[] args){
		int[][] matrix = { { 0, 0, 2, 0, 0, 0, 0, 4, 1 },
                                                { 0, 0, 0, 0, 8, 2, 0, 7, 0 },
                                                { 0, 0, 0, 0, 4, 0, 0, 0, 9 },
                                                { 2, 0, 0, 0, 7, 9, 3, 0, 0 },
                                                { 0, 1, 0, 0, 0, 0, 0, 8, 0 },
                                                { 0, 0, 6, 8, 1, 0, 0, 0, 4 },
                                                { 1, 0, 0, 0, 9, 0, 0, 0, 0 },
                                                { 0, 6, 0, 4, 3, 0, 0, 0, 0 },
                                                { 8, 5, 0, 0, 0, 0, 4, 0, 0 } };
 

		//System.out.print(in_row(matrix,0,1));
		if (solve_it(matrix,0,0)){
			System.out.print("solved puzzle successfully!\nHere are the results");
			print(matrix);
		}
		else{
			System.out.print("failed to solve puzzle");
		}
	}
}
