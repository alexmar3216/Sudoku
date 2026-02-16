//Alexander Marriott
//CS 143
//HW #3: Sudoku #3 (solve)

import java.io.*;

public class SudokuSolverEngine {

   public static void main(String[] args) throws FileNotFoundException {
      solveFile("boards/very-fast-solve.sdk");
      solveFile("boards/fast-solve.sdk");
      solveFile("boards/dirty-data.sdk");
      solveFile("boards/valid-complete.sdk");
      }

   // pre: The string must be a valid file path to a specific file.
   // post: A series of strings displaying the desired board before and after being solved will be printed out.
   //       If the board is invalid or is already solved, a message indicating that will be printed out. 
   public static void solveFile(String file_path) throws FileNotFoundException{
      MySudokuBoard board = new MySudokuBoard(file_path);
      if(!board.isValid()){
         System.out.println("This board cannot be solved.");
      }else if(board.isSolved()){
         System.out.println("This board is already solved.");
      }else{
         System.out.println("Initial board");
         System.out.println(board);
         System.out.println();
         
         System.out.print("Solving board...");
         long start = System.currentTimeMillis();
         board.solve();
         long stop = System.currentTimeMillis();
         System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
         System.out.println();
         System.out.println(board);
      }
      
   }
}


/* output from running this code

  ----jGRASP exec: java SudokuSolverEngine
 Initial board
 
  0 3 4 | 6 7 8 | 9 1 2
  0 7 2 | 1 9 5 | 3 4 8
  1 9 8 | 3 4 2 | 5 6 7
  ------+-------+------
  0 0 9 | 0 6 1 | 4 2 3
  0 2 6 | 8 5 3 | 7 9 1
  0 1 3 | 9 2 4 | 0 5 6
  ------+-------+------
  0 6 1 | 5 3 7 | 2 8 4
  0 8 0 | 4 1 9 | 6 3 5
  3 4 5 | 0 8 6 | 1 7 9
 
 
 Solving board...SOLVED in 0.907 seconds.
 
 
  5 3 4 | 6 7 8 | 9 1 2
  6 7 2 | 1 9 5 | 3 4 8
  1 9 8 | 3 4 2 | 5 6 7
  ------+-------+------
  8 5 9 | 7 6 1 | 4 2 3
  4 2 6 | 8 5 3 | 7 9 1
  7 1 3 | 9 2 4 | 8 5 6
  ------+-------+------
  9 6 1 | 5 3 7 | 2 8 4
  2 8 7 | 4 1 9 | 6 3 5
  3 4 5 | 2 8 6 | 1 7 9
 
 Initial board
 
  8 2 7 | 1 5 4 | 3 9 6
  9 6 5 | 0 2 7 | 1 4 8
  3 4 1 | 6 0 9 | 7 5 2
  ------+-------+------
  0 0 0 | 0 0 0 | 0 0 0
  0 0 0 | 0 0 0 | 0 0 0
  6 1 8 | 9 7 0 | 4 3 5
  ------+-------+------
  7 8 6 | 2 3 5 | 0 1 4
  1 5 4 | 7 9 6 | 8 0 3
  2 3 9 | 8 4 0 | 0 0 0
 
 
 Solving board...SOLVED in 3.683 seconds.
 
 
  8 2 7 | 1 5 4 | 3 9 6
  9 6 5 | 3 2 7 | 1 4 8
  3 4 1 | 6 8 9 | 7 5 2
  ------+-------+------
  4 7 2 | 5 1 3 | 6 8 9
  5 9 3 | 4 6 8 | 2 7 1
  6 1 8 | 9 7 2 | 4 3 5
  ------+-------+------
  7 8 6 | 2 3 5 | 9 1 4
  1 5 4 | 7 9 6 | 8 2 3
  2 3 9 | 8 4 1 | 5 6 7
 
 This board cannot be solved.
 This board is already solved.
 
  ----jGRASP: Operation complete.
*/