class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int seto = 0;
        int setc = 0;
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if(c == '('){
                ans[i] = seto;
                seto ^=1;
            }else{
                ans[i] = setc;
                setc ^= 1;
            }
        }
        return ans;
    }
}