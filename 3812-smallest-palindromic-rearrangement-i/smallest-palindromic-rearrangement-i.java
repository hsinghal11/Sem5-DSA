class Solution {
    public String smallestPalindrome(String s) {
         int[] f = new int[26];
        for(char c: s.toCharArray()){
            f[c-'a']++;
        }
        StringBuilder start = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for(int i=0; i<26; i++){
            if(f[i] % 2 !=0){
                mid.append((char)(i+97));
            }
            int t = f[i]/2;
            while (t-- > 0){
                start.append((char)(i+97));
            }
        }
        return start+mid.toString()+start.reverse();
    }
}