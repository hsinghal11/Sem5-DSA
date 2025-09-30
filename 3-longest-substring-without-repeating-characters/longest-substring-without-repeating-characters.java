class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int ans = 0;
        int ei=0;
        int n = s.length();
        int si = 0;
        while(ei<n){
            while(st.contains(s.charAt(ei))){
                st.remove(s.charAt(si));
                si++;
            }

            st.add(s.charAt(ei));
            int len = st.size();
            ans = Math.max(ans, len);
            ei++;
        }
        return ans;
        
    }
}