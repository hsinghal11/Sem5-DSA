class Solution {
    public int minOperations(String s) {
        int ans = 0;
        for(char c : s.toCharArray()){
            ans = Math.max(ans, (26- (c-'a'))%26);     
        }
        return ans;
    }
}