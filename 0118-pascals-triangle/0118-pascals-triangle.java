class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
           List<Integer> temp = new ArrayList<>(); 
           int j = 0;
           List<Integer> check = new ArrayList<>();
           if(i>0) check = ans.get(i-1);
            while(j<=i){
                if(j==0 || j==i) temp.add(j,1);
                else{
                    int addThis = check.get(j-1)+check.get(j);
                    temp.add(j,addThis);
                }
                j++;
            }
           ans.add(temp);
           
        }
        return ans;
    }
}