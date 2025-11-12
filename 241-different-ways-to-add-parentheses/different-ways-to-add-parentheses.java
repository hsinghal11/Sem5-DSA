class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int ch=0; ch<expression.length(); ch++){
            char i = expression.charAt(ch);
            if(i=='+' || i=='*' || i=='-'){
                List<Integer> Left = diffWaysToCompute(expression.substring(0,ch));
                List<Integer> Right = diffWaysToCompute(expression.substring(ch+1));

                for(int n: Left){
                    for(int m: Right){
                        if(i=='+') ans.add(n+m);
                        else if(i=='*') ans.add(n*m);
                        else ans.add(n-m);
                    }
                }
            }
            
        }
        if(ans.size() == 0)
            ans.add(Integer.valueOf(expression));
        return ans;
    }
}