//Java program to solve a sudoku puzzle
//a file with the Sudoku puzzle grid must be supplied. Please refer to the README.md file for complete instructions.
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class Sudoku{

	static int dim = 9;
	static int box_dim = 3;	
	//read matrix from file provided
	
	static int[][] read_file(String file, int[][] matrix) throws Exception {
      		Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
      		while(sc.hasNextLine()) {
         		for (int i=0; i<matrix.length; i++) {
            			String[] line = sc.nextLine().trim().split(" ");
            			for (int j=0; j<line.length; j++) {
               				matrix[i][j] = Integer.parseInt(line[j]);
            			}
         		}
      		}
      		return matrix;
   	}

        //print matrix
	static void print(int[][] matrix)
        {
                for (int i = 0; i < dim; i++) {
                        for (int j = 0; j < dim; j++)
                                System.out.print(matrix[i][j] + " ");
                        System.out.print("\n");
                }
        }


	//check if a value (num) is in the 3*3 box of the of the field. If it exists it returns true else it returns false 
	static boolean in_box(int[][] matrix, int row, int col, int num){
		int left_border = (col/box_dim) *box_dim;
		int upper_border = (row/box_dim) *box_dim;
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
		for(int check_col=0;check_col<dim; check_col++){
				if(num == matrix[row][check_col]){
				return true;
				}
			}
		return false;
	
	}
	//check if a value (num) is in a row of the field. If it exists it returns true else it returns false 
	static boolean in_col(int[][] matrix, int col, int num){
		for(int check_row=0;check_row<dim; check_row++){
				if(num == matrix[check_row][col]){
				return true;
				}
			}
		return false;
	
	}
	//it will try to fill in the field by trying numbers 1-9 and checking if they exists in box or in the row or the column. 
	//If it find a  none existing number it will fill it in the matrix argument and return. If it can not find a number it will return False. 
	static boolean try_to_fill(int[][] matrix, int row, int col, int num){
		//checking all the combinations in a specific field
			if(!in_box(matrix, row,col,num) && !in_row(matrix,row,num) && !in_col(matrix,col,num)){
				matrix[row][col] = num;
			        return true;

				
			}
			//if we put a number that doesn't work we back track
				return false;
	}

	static boolean solve_it(int[][] matrix, int row, int col){
		//check if we reach the end of the row. if so we need to move to the next row		
		if(col ==dim ){
			row++;
			col =0;
		}
		// if we moved beyond the last row then we return that it was successfull.
		if(row==dim){ return true;}
	
	// if it is already filled we move to the next box

		if (matrix[row][col] >0){
			return solve_it(matrix, row, col+1);
		}
		// we try to fill an empty box by trying different combinations and if not we return a failed code
		for(int i=1;i<10;i++){
			if(try_to_fill(matrix, row,col,i)){
	                	//when we find a good number we call the recursive function
				if(solve_it(matrix,row,col+1)) {
					return true;
				}
			}
			//if the tried number didnt work we reset it so we can go back to it if we backtrack
			matrix[row][col] = 0;
		}
		return false;
	}

	public static void main(String[] args){
      		int [][] matrix = new int[dim][dim];
		try{
			matrix = read_file(args[0], matrix);
		}
		catch (Exception e){
			System.out.print("please provide a valid file name for the Sudoku matrix");
			System.out.println();
			System.out.print(e.getMessage());
			return;
		}
		if (solve_it(matrix,0,0)){
			System.out.print("solved puzzle successfully!\n");
			print(matrix);
		}
		else{
			System.out.print("failed to solve puzzle");
		}
	}
}
