class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Integer>[] gp = new ArrayList[n];
        boolean addAll = false;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            gp[i] = new ArrayList<>();

        for (int[] d : invocations) {
            int a = d[0];
            int b = d[1];
            gp[a].add(b);
        }

        boolean[] inf = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        while (!q.isEmpty()) {
            int poll = q.poll();
            if (inf[poll])
                continue;

            inf[poll] = true;

            q.addAll(gp[poll]);
        }
        boolean[] vis = new boolean[n];
        for (int nn = 0; nn < n; nn++) {
            if (inf[nn] || vis[nn])
                continue;

            q.add(nn);
            while (!q.isEmpty()) {
                int poll = q.poll();
                if (vis[poll])
                    continue;
                ans.add(poll);

                vis[poll] = true;

                for (int i : gp[poll]) {
                    if (inf[i]) {
                        addAll = true;
                        break;
                    } else {
                        q.offer(i);
                    }
                }
            }
        }
        if (addAll) {
            ans = new ArrayList<>();
            for (int i = 0; i < n; i++)
                ans.add(i);
        }

        return ans;
    }
}