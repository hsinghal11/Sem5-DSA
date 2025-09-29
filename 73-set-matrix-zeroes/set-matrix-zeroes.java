class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowCnt = new HashSet<>();
        Set<Integer> colCnt = new HashSet<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowCnt.add(i);
                    colCnt.add(j);
                }
            }
        }
        for(int row: rowCnt){
            rowZero(matrix, row);
        }
        for(int col: colCnt){
            colZero(matrix, col);
        }
    }

    private static void rowZero(int[][] arr, int row){
        for(int col=0; col<arr[0].length; col++){
            arr[row][col] = 0;
        }
    }
    
    private static void colZero(int[][] arr, int col){
        for(int row=0; row<arr.length; row++){
            arr[row][col] = 0;
        }
    }
}