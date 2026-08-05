class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int m = invocations.length;

        // Build CSR adjacency list for forward edges (a -> b) and reverse edges (b -> a)
        int[] outDeg = new int[n];
        for (int[] e : invocations) outDeg[e[0]]++;
        int[] head = new int[n + 1];
        for (int i = 0; i < n; i++) head[i + 1] = head[i] + outDeg[i];
        int[] adj = new int[m];
        int[] pos = head.clone();
        for (int[] e : invocations) adj[pos[e[0]]++] = e[1];

        // Step 1: find all suspicious methods (k + everything reachable from k)
        boolean[] suspicious = new boolean[n];
        int[] queue = new int[n];
        int qh = 0, qt = 0;

        suspicious[k] = true;
        queue[qt++] = k;
        while (qh < qt) {
            int u = queue[qh++];
            for (int i = head[u]; i < head[u + 1]; i++) {
                int v = adj[i];
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    queue[qt++] = v;
                }
            }
        }

        // Step 2: check if any NON-suspicious method invokes a suspicious method
        boolean canRemove = true;
        for (int[] e : invocations) {
            int a = e[0], b = e[1];
            if (!suspicious[a] && suspicious[b]) {
                canRemove = false;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (canRemove) {
            for (int i = 0; i < n; i++) if (!suspicious[i]) ans.add(i);
        } else {
            for (int i = 0; i < n; i++) ans.add(i);
        }
        return ans;
    }
}