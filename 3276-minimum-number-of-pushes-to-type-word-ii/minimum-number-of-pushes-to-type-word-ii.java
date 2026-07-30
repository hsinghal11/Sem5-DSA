class Solution {
    public int minimumPushes(String s) {
        int[] f = new int[26];
        for(char c: s.toCharArray()){
            f[c-'a']++;
        }
Arrays.sort(f);
        int c = 1;
        int ans = 0;
        int dial = 2;
        for(int i=25; i>=0; i--) {
            if(f[i] == 0) break;
            ans += f[i] * c;
            dial++;
            if(dial == 10){
                dial = 2;
                c++;
            }
        }
        return ans;
    }
}