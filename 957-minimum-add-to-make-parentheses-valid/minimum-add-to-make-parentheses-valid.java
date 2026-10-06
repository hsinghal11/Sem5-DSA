class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            while (i<s.length() && s.charAt(i) == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
                i++;
            }
            if(i < s.length())
                st.push(s.charAt(i));
        }
        return st.size();
    }
}