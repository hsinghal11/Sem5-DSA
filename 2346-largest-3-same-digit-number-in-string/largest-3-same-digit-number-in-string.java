class Solution {
    public String largestGoodInteger(String num) {
        String ans = "0";
        for(int i=0 ;i<num.length()-2; i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+2)==num.charAt(i+1)){
                if(ans.charAt(0)<=num.charAt(i)){
                    ans = num.substring(i,i+3);
                }
            }
        }
        if(ans=="0") return "";
        return ans;
    }
}