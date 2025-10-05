class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && Math.abs(st.peek() - c) == 32) {
                // Adjacent characters are same letter with different cases
                st.pop();
            } else {
                st.push(c);
            }
        }
        // Build the result from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);
        return sb.toString();
    }
}