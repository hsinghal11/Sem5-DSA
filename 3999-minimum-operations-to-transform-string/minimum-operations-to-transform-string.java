class Solution {
    public int minOperations(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != 'a'){
                ans = Math.max(ans, Math.abs((int)(s.charAt(i)-123)));
            } 
        }
        return ans;
    }
}