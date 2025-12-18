class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        String l = strs[0];
        String r = strs[n-1];
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<l.length(); i++){
            if(l.charAt(i) != r.charAt(i)){
                return ans.toString();
            }else{
                ans.append(l.charAt(i));
            }
        }
        return ans.toString();
        
    }
}