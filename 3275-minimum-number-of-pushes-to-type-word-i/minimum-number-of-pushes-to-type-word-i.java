class Solution {
    public int minimumPushes(String s) {
        int dial = 2;
        int[] f = new int[26];
        int[] d = new int[10];
        int ans = 0;
        for(char c: s.toCharArray()){
            if(f[c-'a'] == 0){
                d[dial]++;
                f[c-'a'] = d[dial];
                dial++;
            }
            if(dial == 10) dial = 2;
            ans += f[c-'a'];
        }
        return ans;
    }
}