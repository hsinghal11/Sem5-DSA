class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ll = new ArrayList<>();
        solve(s, new ArrayList<String>(), 0, ll);
        return ll;
    }
    public void solve(String s,List<String> l, int idx, List<List<String>> ll){
        if(idx == s.length()){
            ll.add(new ArrayList<>(l));
            return;
        }
        for(int i= idx; i<s.length(); i++){
            if(isPlaindrome(idx, i, s)){
                l.add(s.substring(idx, i+1));
                solve(s,l, i+1,ll);
                l.remove(l.size()-1);
            }
        }
    }

    public boolean isPlaindrome(int s, int e, String st){
        while(s < e){
            if(st.charAt(s) == st.charAt(e)){
                s++;
                e--;
            }else{
                return false;
            }
        }
        return true;
    }
}