class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int max2 = -1;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int ele = s.charAt(i)-'0';
                if(ele > max){
                    max2 = max;
                    max = ele;
                }else if(ele!=max && ele > max2){
                    max2 = ele;
                }
            }
        }
        return max2;
    }
}