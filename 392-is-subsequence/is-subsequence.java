class Solution {
    public boolean isSubsequence(String s, String t) {
       int n = s.length();
       int m = t.length();
       if(m<n) return false;
       int i = 0;
       int j = 0;
       while(i<n && j<m){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
       }
       if(i<n) return false;
       else return true;
    }
}