class Solution {
    String ans = "";
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        if(solve(new StringBuilder(), freq, 0, target, false)) return ans;
        return "";

        
    }

    public boolean solve(StringBuilder sb, int[] freq, int index, String target, boolean isGreat){
        if(sb.length() == target.length()){
            if(sb.toString().compareTo(target) > 0){
                ans = sb.toString();
                return true;
            }
            return false;
        }

        for(char c='a'; c<='z'; c++){
            int idx = c-'a';
            if(freq[idx] == 0) continue;

            if (!isGreat && c < target.charAt(index)) {
                continue;
            }

            sb.append(c);
            freq[idx]--;

            boolean isGreater = isGreat || c > target.charAt(index);

            if(solve(sb, freq, index+1, target, isGreater)) return true;

            sb.deleteCharAt(sb.length() - 1);
            freq[idx]++;
        }
        return false;
    }
}