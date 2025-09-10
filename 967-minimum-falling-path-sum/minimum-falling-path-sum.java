class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -66666);
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            answer = Math.min(answer, ans(matrix, 0, i, dp));
        }
        return answer;
    }

    private int ans(int[][] matrix, int cr, int cc, int[][] dp) {
        if(cc < 0 || cc >= matrix[0].length){
            return Integer.MAX_VALUE;
        }

        if(cr == matrix.length -1){
            return matrix[cr][cc];
        }

        if(dp[cr][cc] != (-66666)){
            return dp[cr][cc];
        }

        int ld = ans(matrix, cr+1, cc-1, dp);
        int rd = ans(matrix, cr+1, cc+1, dp);
        int d = ans(matrix, cr+1, cc, dp);
        return dp[cr][cc] = Math.min(rd, Math.min(ld, d)) + matrix[cr][cc];
    }
}