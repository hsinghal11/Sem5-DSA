class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder ss = new StringBuilder();
        StringBuilder tt = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c != '#'){
                ss.append(c);
            }else if(ss.length() > 0){
                ss.deleteCharAt(ss.length() - 1);
            }
        }
        for(char c:t.toCharArray()){
            if(c != '#'){
                tt.append(c);
            }else if(tt.length() > 0){
                tt.deleteCharAt(tt.length() - 1);
            }
        }
        return ss.toString().equals(tt.toString());
    }
}