class Solution {
    public int characterReplacement(String s, int k) {
        int[] f = new int[128];
        int si = 0;
        int ei = 0;
        int n = s.length();
        int ans = 0;
        int maxF = 0;
        while(ei<n){
            // grow
            char rc = s.charAt(ei);
            f[rc]++;
            maxF = Math.max(maxF, f[rc]);
            int len = ei-si+1;
            // shrink
            while(len - maxF >k){
                char lc = s.charAt(si);
                f[lc]--;
                si++;
                len = ei-si+1;
            }

            // update
            ans = Math.max(ans, len);
            ei++;
        }
        return ans;
    }
}