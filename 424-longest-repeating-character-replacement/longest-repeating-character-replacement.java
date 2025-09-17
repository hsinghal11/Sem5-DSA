class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int si = 0;
        int ei = 0;
        int maxFreq = 0;
        int ans = 0;
        while(ei<s.length()){
            // increase the window
            char c = s.charAt(ei);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(c));

            int len = ei - si + 1;

            // shrink window if valid
            while(len - maxFreq > k){
                char lc = s.charAt(si);
                mp.put(lc, mp.get(lc) - 1);
                si++;
                len = ei-si+1;
            }
            ans = Math.max(ans, len);
            ei++;
        }
        return ans;
    }
}