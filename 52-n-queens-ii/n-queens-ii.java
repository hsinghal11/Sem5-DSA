class Solution {
    static int cnt;
    public int totalNQueens(int n) {
        cnt = 0;
        String[][] board = new String[n][n];
        for(String[] c: board){
            Arrays.fill(c, ".");
        }
        solveQueens(board, n, 0);
        return cnt;
    }

    public void solveQueens(String[][] board, int n, int curr){
        if(n==0){
            cnt++;
            return;
        }
        for(int col=0; col<board[0].length; col++){
            if(isItSafe(board, col, curr)){
                board[curr][col] = "Q";
                solveQueens(board, n-1, curr+1);
                board[curr][col] = ".";
            }
        }
    }

    public boolean isItSafe(String[][] board, int col, int row){
        // upper
        for (int i = row; i >= 0 ; i--) {
            if(board[i][col] == "Q") return false;
        }
        // diagonal left
        int r = row;
        int c = col;
        while (r>=0 && c>=0 ){
            if(board[r][c] == "Q") return false;
            r--;
            c--;
        }
        // diagonal right
        r = row;
        c= col;
        while (r >= 0 && c <board[0].length){
            if(board[r][c] == "Q") return false;
            r--;
            c++;
        }
        return true;
    }
}