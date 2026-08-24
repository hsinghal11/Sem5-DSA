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
        if((ql+qr) % 2 != 0) return true;

        if(((qr-ql)*9)/2 != ls-rs) return true;
        return false;
    }
}