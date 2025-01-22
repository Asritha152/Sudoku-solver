import java.util.Arrays;

public class sudoku {
        public static boolean isSafe(String[][] board,int r,int c){
            //check row
            for (int i = 0; i < board[0].length; i++) {
               if (i!=c && board[r][i].equals(board[r][c])) {
                return false;
                
               }
            }
            //check column
            for (int i = 0; i < board.length; i++) {
                if (i!=r && board[i][c].equals(board[r][c])) {
                 return false;
                 
                }
             }
              // Check box
        int boxStartRow = (r / 3) * 3;
        int boxStartCol = (c / 3) * 3; 
        
        for (int i = boxStartRow; i < boxStartRow + 3; i++) {
            for (int j = boxStartCol; j < boxStartCol + 3; j++) {
                if ((i != r || j != c) && board[i][j].equals(board[r][c])) {
                    return false;
                }
            }
        }
        
        return true; 
    
        }
        public static boolean SudokuSolver(String [][] board){//only board
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]==".") {
                        for (int j2 = 1; j2 <10; j2++) {
                            board[i][j]=Integer.toString(j2);
                            if (isSafe(board, i, j)) {
                                if (SudokuSolver(board)) {
                                    return true;
                                    
                                }
                               
                                
                            }
                            board[i][j]=".";
                            
                        }
                        return false;
                     
                    }
                   
                    
                }
                
            }
            return true;
    
        }
        public static void displayBoard(String [][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
            
        }

        }
        public static void main(String[] args) {
            String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
            };
            if(SudokuSolver(board)){
                displayBoard(board);
            }
            else{
                System.out.println("The given sudoku puzzle cannot be solved");
            }
            
            
        }
    
}
