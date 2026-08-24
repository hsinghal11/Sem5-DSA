class Solution {
    public boolean sumGame(String num) {
        int ql =0, qr = 0, idx = 0, ls = 0, rs = 0;
        int n = num.length();
        int mid = n/2;
        for(char c: num.toCharArray()){
            if(c == '?' && idx < mid) ql++;
            else if(c == '?') qr++;
            else{
                if(idx<mid) ls += c-'0';
                else rs += c-'0';
            } 
            idx++;
        }

        int diff = qr-ql;
        System.out.println(ls+" "+rs);
        if(diff == 0 && ls == rs) return false;
        if(diff == 0 && ls != rs) return true;

        if(diff%2 !=0) return true;

        int sum_diff = rs -ls;
        if(sum_diff*diff > 0) return true;

        if(sum_diff%9 != 0) return true;
    
        if(Math.abs(sum_diff / (diff/2)) == 9) return false;
        return true;
    }
}