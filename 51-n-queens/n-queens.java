class Solution {
    static List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        String[][] board = new String[n][n];
        for(String[] c: board){
            Arrays.fill(c, ".");
        }
        solveQueens(board, n, 0);
        return ans;
    }

    public void solveQueens(String[][] board, int n, int curr){
        List<String> ll = new ArrayList<>();
        if(n == 0){
            for(int i=0; i<board.length; i++){
                String s = "";
                for(int j=0; j<board[0].length; j++){
                    s += board[i][j];
    
                }
                ll.add(s);   
            }
            ans.add(new ArrayList<>(ll));
            ll.removeLast();
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