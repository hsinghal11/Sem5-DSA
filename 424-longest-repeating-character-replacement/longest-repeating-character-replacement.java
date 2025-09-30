class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int si = 0;
        int ei = 0;
        int n = s.length();
        int ans = 0;
        int maxF = 0;
        while(ei<n){
            // grow
            char rc = s.charAt(ei);
            mp.put(rc, mp.getOrDefault(rc, 0)+1);
            maxF = Math.max(maxF, mp.get(rc));
            int len = ei-si+1;
            // shrink
            while(len - maxF >k){
                char lc = s.charAt(si);
                mp.put(lc, mp.get(lc)-1);
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