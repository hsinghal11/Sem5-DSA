class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        int n = name.length();
        int m = typed.length();
        while(j < m){
            if(i < n && name.charAt(i) == typed.charAt(j)){
                j++;
                i++;
            }else if (j>0 && typed.charAt(j) == typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        return i==name.length();
    }
}