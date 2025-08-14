class Solution {
    public String largestGoodInteger(String s) {
        char ans=' ';
        for(int i=0; i< s.length()-2; i++){
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i+1)==s.charAt(i+2)){
                if(ans<s.charAt(i)) ans = s.charAt(i);
            }
        }
        if(ans == ' ')return "";
        return (ans+""+ans+""+ans);
    }
}