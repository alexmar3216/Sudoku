//Alexander Marriott
//CS 143
//HW #1: Sudoku #1 (Board Setup)

import java.util.*;
import java.io.*;
public class SudokuBoard{

   private int[][] board;
   
   public SudokuBoard(String board_name) throws FileNotFoundException{
      board = new int[9][9];
      Scanner input = new Scanner(new File(board_name));
      for (int i=0; i<9; i++){
         String current = input.nextLine();
         for (int j=0; j<9; j++){
            if (current.charAt(j) == '1') {
               board[i][j] = 1;
            }
            else if(current.charAt(j) == '2') {
               board[i][j] = 2;
            }
            else if(current.charAt(j) == '3') {
               board[i][j] = 3;
            }
            else if(current.charAt(j) == '4') {
               board[i][j] = 4;
            }
            else if(current.charAt(j) == '5') {
               board[i][j] = 5;
            }
            else if(current.charAt(j) == '6') {
               board[i][j] = 6;
            }
            else if(current.charAt(j) == '7') {
               board[i][j] = 7;
            }
            else if(current.charAt(j) == '8') {
               board[i][j] = 8;
            }
            else if(current.charAt(j) == '9') {
               board[i][j] = 9;
            }
            else{
               board[i][j] = 0;
            }
         }
      }
        
   }
   
   // pre: none
   // post: a string with all the file's contents placed in respictive 3x3 squares separated
   //       by a 3x3 grid made up of minuses, pluses, and vertical bars should be returned. 
   public String toString(){
      String vis_board = "\n";
      for (int m=0; m<2; m++){   
         for (int l=0;l<3;l++){ 
            for (int k=0;k<3;k++){
               vis_board = vis_board + " " +board[(3*m)+l][k];
            }
            for (int i=0; i<2; i++){
               vis_board = vis_board + " |";
               for (int j=0;j<3;j++){
                  vis_board = vis_board + " " +board[(3*m)+l][((i*3)+j+3)];
               }
            }
            vis_board = vis_board + "\n";
         }
         vis_board = vis_board + " ------+-------+------\n";
         
      }
      for (int l=0;l<3;l++){ 
            for (int k=0;k<3;k++){
               vis_board = vis_board + " " +board[6+l][k];
            }
            for (int i=0; i<2; i++){
               vis_board = vis_board + " |";
               for (int j=0;j<3;j++){
                  vis_board = vis_board + " " +board[6+l][((i*3)+j+3)];
               }
            }
            vis_board = vis_board + "\n";
         }
      return vis_board;
   }
}

/* output from running this code
  ----jGRASP exec: javac -g SudokuBoard.java
 
  ----jGRASP: Operation complete.
*/
