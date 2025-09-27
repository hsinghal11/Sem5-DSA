class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for(char c: s.toCharArray()){
            freq[c]++;
        }
        // char ch[]=new char[s.length()];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int max = -1;
            int idx = 0;
            for(int j=0; j<128; j++){
                if(freq[j] > max){
                    max = freq[j];
                    idx = j;
                }
            }

            while(max-- > 0){
                // ch[i++] = (char)idx;
                
                sb.append(((char)idx)+"");
                i++;
            }
            freq[idx] = 0;
        }
        return sb.toString();
        // return new String(ch);
    }
}