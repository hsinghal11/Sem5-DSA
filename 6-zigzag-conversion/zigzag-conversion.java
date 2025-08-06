class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()==numRows) return s;
        StringBuilder[] res=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            res[i]=new StringBuilder();
        }
        int st = 0;
        boolean down = true;

        for(int i = 0; i < s.length(); i++) {
            res[st].append(s.charAt(i));

            if(down) {
                st++;
                if(st == numRows) {
                    down = false;
                    st = numRows - 2;
                }
            } else {
                st--;
                if(st == -1) {
                    down = true;
                    st = 1;
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder sb:res){
            ans.append(sb.toString());
        }
        return ans.toString();
    }
}