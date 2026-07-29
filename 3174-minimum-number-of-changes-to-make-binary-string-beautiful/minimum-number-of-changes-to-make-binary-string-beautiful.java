class Solution {
    public int minChanges(String s) {
        char p = s.charAt(0);
        int i = 1;
        int c = 1;
        int ans = 0;
        while(i < s.length()){
            if(c == 1){
                if(s.charAt(i) != p){
                    ans++;
                }
                c = 0;
            }else{
                p = s.charAt(i);
                c++;
            }
            i++;
        }
        return ans;
    }
}