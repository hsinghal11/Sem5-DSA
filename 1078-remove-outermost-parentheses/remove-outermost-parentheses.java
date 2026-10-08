class Solution {
    public String removeOuterParentheses(String s) {
        int dept = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            if(c == '('){
                dept++;
                if(dept != 1) sb.append(c);
            }
            else{
                dept--;
                if(dept != 0) sb.append(c);
            }
        }
        return sb.toString();
    }
}