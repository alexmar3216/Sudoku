//Alexander Marriott
//CS 143
//HW #1: Sudoku #1 (Board Setup)

import java.util.*;
import java.io.*;

public class PlaySudoku{

   public static void main(String[] args) throws FileNotFoundException{
   
      SudokuBoard test = new SudokuBoard("data1-1-1.sdk");
      
      System.out.println(test);   
   }
}

/* output from running this code

  ----jGRASP exec: java PlaySudoku
 
  2 0 0 | 1 0 5 | 0 0 3
  0 5 4 | 0 0 0 | 7 1 0
  0 1 0 | 2 0 3 | 0 8 0
  ------+-------+------
  6 0 2 | 8 0 7 | 3 0 4
  0 0 0 | 0 0 0 | 0 0 0
  1 0 5 | 3 0 9 | 8 0 6
  ------+-------+------
  0 2 0 | 7 0 1 | 0 6 0
  0 8 1 | 0 0 0 | 2 4 0
  7 0 0 | 4 0 2 | 0 0 1
 
 
  ----jGRASP: Operation complete.

*/