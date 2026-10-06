class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int o = 0;
        for(char c: s.toCharArray()){
            if(c == '(') o++;
            else{
                if(o > 0) o--;
                else ans++;
            }
        }
        return o+ans;
    }
}