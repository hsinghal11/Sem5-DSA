class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9) return "";

        StringBuilder ans = new StringBuilder();
        int start = 9;
        int i = 0;
        while (i < num && sum > 0){
            ans.append(Math.min(sum, start));
            sum -= start;
            i++;
        }
        
        while (i< num){
            ans.append(0);
            i++;
        }
        return sum > 0?"" :ans.toString();
    }
}