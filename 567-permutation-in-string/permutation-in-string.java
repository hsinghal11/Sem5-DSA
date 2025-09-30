class Solution {
    public boolean checkInclusion(String p, String s) {
        int n = s.length();
        int m = p.length();
        if(m > n) return false;
        int[] f1 = new int[128];
        int[] f2 = new int[128];
        for(char c: p.toCharArray()){
            f1[c]++;
        }
        int si = 0;
        int c = 0;
        int ei = 0;
        while(ei<n && si<n){
            // groww
            f2[s.charAt(ei)]++;
        
            // shrink
            while(ei-si+1 >m){
                f2[s.charAt(si)]--;
                si++;
            }

            // update
            if(ei-si+1 == m && Arrays.equals(f1, f2)){
                return true;
            }
            ei++;
        }   
        return false;
    }
}