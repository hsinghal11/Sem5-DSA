class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.') continue;
                else{
                    if(isItSafe(board, i, j) == false) return false;
                    else continue;
                }
            }
        }
        return true;
    }

    public boolean isItSafe(char[][] board, int row, int col){
        //check col
        for(int i=0; i<board[0].length; i++){
            if(board[row][col] == board[row][i] && i!= col) return false;
        }
    
        //check row
        for(int i=0; i<board.length; i++){
            if(board[row][col] == board[i][col] && i!=row) return false;
        }

        int r = row - row % 3;
        int c = col - col % 3;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if((i != row || j != col) && board[i][j] == board[row][col]) return false;
            }
        }
        return true;
    }
}