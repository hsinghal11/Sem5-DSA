class Solution {
    public int strStr(String h, String ne) {

        int n = h.length();
        int m = ne.length();
        int ans = -1;
        if(m>n){
            return -1;
        }
        if(h.equals(ne)){
            return 0;
        }
        
        for(int i=0; i<n-m+1; i++){
            if(h.substring(i,i+m).equals(ne.substring(0))){
                return i;
            }
        }
        return -1;
   }
}