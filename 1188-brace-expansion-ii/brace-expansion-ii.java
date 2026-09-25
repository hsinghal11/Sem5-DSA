class Solution {
    TreeSet<String> expAns = new TreeSet<>();

    public void dfs(String s){
        int ri = s.indexOf('}');

        if(ri == -1){
            expAns.add(s);
            return;
        }

        int li = s.lastIndexOf('{', ri);

        String start = s.substring(0, li);
        String inside = s.substring(li+1, ri);
        String end = s.substring(ri+1);

        for(String p : inside.split(",")){
            dfs(start+p+end);
        }

    }

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
         return new ArrayList<>(expAns);
    }
}