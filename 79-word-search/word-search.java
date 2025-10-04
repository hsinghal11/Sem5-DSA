class Solution {
    public boolean exist(char[][] board, String word) {
        int idx = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(idx)){
                    if(solve(board, word, idx, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean solve(char[][] board, String word, int idx, int i, int j){
        if(idx == word.length()){ 
            return true;
        }
        if(i<0|| i>board.length-1 || j<0 || j>board[0].length-1 ||board[i][j] != word.charAt(idx) ){
            return false;
        }
        board[i][j] += 100;
        boolean exist = solve(board, word, idx+1, i-1, j) ||
                        solve(board, word, idx+1, i, j-1) ||
                        solve(board, word, idx+1, i+1, j) ||
                        solve(board, word, idx+1, i, j+1);  

        board[i][j] -= 100;

        return exist;
    }
}