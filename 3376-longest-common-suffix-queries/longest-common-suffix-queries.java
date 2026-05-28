class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root=new TrieNode();

        int min = Integer.MAX_VALUE;
        int idx = -1;

        for(int i=0; i<wordsContainer.length; i++){
            insert(root,wordsContainer[i], i);
            if(min > wordsContainer[i].length()){
                min = wordsContainer[i].length();
                idx = i;
            }
        }

        int[] ans = new int[wordsQuery.length];

        for(int i=0; i<wordsQuery.length; i++){
            ans[i]=search(root,wordsQuery[i]);
            if(ans[i] == -1) ans[i] = idx; 
        }
        return ans;
    }

    public void insert(TrieNode root, String s, int id){
        int n = s.length();
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            int idx = c-'a';
            if(root.child[idx] == null){
                root.child[idx] = new TrieNode();
            }
            root = root.child[idx];
            if(root.l > n){
                root.l = n;
                root.idx = id;
            }
        }
    }

    public int search(TrieNode root, String s){
        TrieNode node=root;
        int n = s.length();
        int ans = 0;
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            int idx = c-'a';
            if(root.child[idx] == null){
                return root.idx;
            }
            root = root.child[idx];
            ans = root.idx;
        }
        return ans;
    }
}
class TrieNode{
    TrieNode[] child;
    int idx = -1;
    int l;

    TrieNode(){
        l = Integer.MAX_VALUE;
        child=new TrieNode[26];
    }
}