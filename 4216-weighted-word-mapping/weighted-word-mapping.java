class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for(String w: words){
            int sum = 0;
            for(char c: w.toCharArray()){
                sum += weights[c-'a'];
            }
            sum %= 26;
            sum = 26-sum + 96;
            ans.append((char)(sum));
        }
        return ans.toString();
    }
}