//Alexander Marriott
//CS 143
//HW #3: Sudoku #3 (solve)
import java.util.*;
import java.io.*;
public class MySudokuBoard{

   private int[][] board;
   
   // constructor. converts string from file into a series of integers in a 2D array.
   public MySudokuBoard(String board_name) throws FileNotFoundException{
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
            else if(current.charAt(j) == '.'){
               board[i][j] = 0;
            }
            else{
               board[i][j] = -1;
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
   
   // pre: none
   // post: a 2D array with the values of the desired 1/9th of the board resembling a miniture 3x3 square
   //       should be returned.
   private int[][] miniSquare(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }
   
   // pre: none
   // post: an array with the values of the desired row on the board should be returned.
   private int[] row(int spot){
      int[] rs = new int[9];
      rs = board[spot];         
      return rs;
   }
   
   // pre: none
   // post: an array with the values of the desired column on the board should be returned.   
   private int[] column(int spot){
      int[] cs = new int[9];
      for(int i=0;i<9;i++){
         cs[i] = board[i][spot];
      }
      return cs;
   }
   
   // pre: none
   // post: a boolen value that indicates if the board is valid based on it not having duplicate numbers
   //       in it's rows, colums, or squares should be returned. true if valid and false if not.
   public boolean isValid(){
      for(int i=0; i<9;i++){
         int[] tst_row = row(i);
         HashSet<Integer> tst = new HashSet<Integer>();
         for(int j=0; j<9; j++){
            if(!tst.contains(tst_row[j])){
               tst.add(tst_row[j]);
            }
            else if (tst.contains(tst_row[j]) && (tst_row[j] != 0) ){
               return false;
            }
         } 
      }
      
      for(int i=0; i<9;i++){
         int[] tst_col = column(i);
         HashSet<Integer> tst = new HashSet<Integer>();
         for(int j=0; j<9; j++){
            if(!tst.contains(tst_col[j])){
               tst.add(tst_col[j]);
            }
            else if (tst.contains(tst_col[j]) && (tst_col[j] != 0)){
               return false;
            }
         } 
      }
      
      for(int i=1; i<10;i++){
         int[][]tst_mini = miniSquare(i);
         HashSet<Integer> tst = new HashSet<Integer>();
         for(int j=0; j<3; j++){
            for(int l=0; l<3;l++){
               if(!tst.contains(tst_mini[j][l])){
                  tst.add(tst_mini[j][l]);
               }
               else if (tst.contains(tst_mini[j][l]) && (tst_mini[j][l] != 0)){
                  return false;
               }
            } 
         }
      }
     
      return true;
   }
  
   // pre: none
   // post: a boolean value that indicates if board is solved should be returned.
      public boolean isSolved(){
      HashMap<Integer,Integer> comp = new HashMap<Integer,Integer>();
      for(int i=1; i<10; i++){
         comp.put(i, 0);
      } 
      for(int i=0; i<9; i++){
         for(int j=0; j<9; j++){
            if(comp.containsKey(board[i][j])){
               int rep = (Integer)comp.get(board[i][j]) +1;
               comp.replace(board[i][j], rep);
            }
            else{
               comp.put(board[i][j], 1);
            }   
         }
      }
      
      if(isValid() != true){
         return false;
      }
      else if(isValid() == true){
         for (int i=1; i<10; i++){
            if(comp.get(i) != 9){
               return false;
            }
         }
      }
       
      return true;
   }

   // pre: none
   // post: A boolean value indcating that the board is solved will be returned. The board will
   //       also be solved.
   
   public boolean solve(){
      boolean boardSolved = false;
      if(!isValid()){
         return false;
      } else if (isSolved()){
         return true;
      } else{
         for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
               if(board[row][col] == 0){
                  for(int i=1; i<=9 && !boardSolved;i++){
                     board[row][col] = i;
                     boardSolved = solve();
                  }
                  if(!boardSolved){
                     board[row][col] = 0;
                  }
               }
            }
         }  
      }
      return boardSolved;
   }

}

/* output from running this code
      ----jGRASP exec: javac -g MySudokuBoard.java
 
  ----jGRASP: Operation complete.
*/
