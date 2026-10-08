class Solution {

    Set<String> set;
    int globalMinRemove;

    public List<String> removeInvalidParentheses(String s) {

        set = new HashSet<>();

        int leftRemove = 0;
        int rightRemove = 0;

        // Calculate minimum removals required
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;

            } else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        globalMinRemove = leftRemove + rightRemove;

        solveInvalid(
            0,
            0,
            leftRemove,
            rightRemove,
            new StringBuilder(),
            s
        );

        return new ArrayList<>(set);
    }

    private void solveInvalid(
        int idx,
        int dept,
        int leftRemove,
        int rightRemove,
        StringBuilder str,
        String original
    ) {

        if (dept < 0) {
            return;
        }

        if (idx == original.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                dept == 0) {

                set.add(str.toString());
            }

            return;
        }

        char c = original.charAt(idx);

        // Normal character
        if (c != '(' && c != ')') {

            str.append(c);

            solveInvalid(
                idx + 1,
                dept,
                leftRemove,
                rightRemove,
                str,
                original
            );

            str.deleteCharAt(str.length() - 1);

            return;
        }

        // -------------------------
        // '('
        // -------------------------
        if (c == '(') {

            // Remove it only if we actually need
            // to remove an '('
            if (leftRemove > 0) {

                solveInvalid(
                    idx + 1,
                    dept,
                    leftRemove - 1,
                    rightRemove,
                    str,
                    original
                );
            }

            // Keep it
            str.append('(');

            solveInvalid(
                idx + 1,
                dept + 1,
                leftRemove,
                rightRemove,
                str,
                original
            );

            str.deleteCharAt(str.length() - 1);
        }

        // -------------------------
        // ')'
        // -------------------------
        else {

            // Remove it only if necessary
            if (rightRemove > 0) {

                solveInvalid(
                    idx + 1,
                    dept,
                    leftRemove,
                    rightRemove - 1,
                    str,
                    original
                );
            }

            // Keep ')' only when valid
            if (dept > 0) {

                str.append(')');

                solveInvalid(
                    idx + 1,
                    dept - 1,
                    leftRemove,
                    rightRemove,
                    str,
                    original
                );

                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}