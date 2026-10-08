class Solution {
    int globalMinRemove = Integer.MAX_VALUE;
    Set<String> set;
    public List<String> removeInvalidParentheses(String s) {
         set = new HashSet<>();
        solveInvalid("", 0, 0, 0, s); // string, index, minRemove, valid
        return new ArrayList<>(set);
    }

    private void solveInvalid(String str, int idx, int minRemove, int dept, String original) {
        if(idx == original.length()){
            if(dept == 0){
                if(minRemove == globalMinRemove) set.add(str);
                if(minRemove < globalMinRemove){
                    globalMinRemove = minRemove;
                    set.clear();
                    set.add(str);
                }
            }
            return;
        }
        
        if(dept < 0) return;
        
         char c = original.charAt(idx);
        if (c != ')' && c != '(') {
            solveInvalid(str+c, idx+1, minRemove, dept, original);
        } else {

            solveInvalid(str, idx + 1, minRemove + 1, dept, original);// notPick
            dept = c == '(' ? dept + 1 : dept - 1;
            solveInvalid(str + c, idx + 1, minRemove, dept, original); //pick
        }
    }
}